package com.niu.controller;

import com.niu.controller.exceptionResolver.CustomerException;
import com.niu.controller.validation.ValidGroup1;
import com.niu.entity.Items;
import com.niu.entity.ItemsExample;
import com.niu.mapper.ItemsMapper;
import com.niu.service.ItemsService;
import com.niu.vo.ItemsQueryVo;
import com.niu.vo.ItemsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by ami on 2018/11/22.
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;
    @Autowired
    private ItemsMapper itemsMapper;

    //商品查询rest
    @RequestMapping("/itemViewRest/{id}")
    @ResponseBody
    public Items itemViewRest(@PathVariable(value = "id") Integer id)throws Exception{
        Items items = itemsService.findItemsById(id);
        return items;
    }

    @RequestMapping("/queryItems")
    public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsVo> itemsList = itemsService.findItemsList(itemsQueryVo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }

    @RequestMapping("/editItem")
    public String editItem(
            Model model,
            HttpServletRequest request,
            @RequestParam(value = "id", required = true) Integer id
    ) throws Exception {
        System.out.println("id=" + request.getParameter("id"));
        Items items = itemsService.findItemsById(id);
        if(null == items){
            throw new CustomerException("找不到商品信息!");
        }
        model.addAttribute("item", items);
        return "editItem";
    }

    @RequestMapping("/editItemSubmit")
    public String editItemSubmit(
            Model model , @Validated(value = {ValidGroup1.class}) Items items, BindingResult bindingResult,
            MultipartFile picture
    ) throws Exception {

        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            model.addAttribute("allErrors",allErrors);
            for(ObjectError error:allErrors){
                System.out.println(error.getDefaultMessage());
            }
            return "editItem";
        }

        //实现上传图片
        if (picture != null && picture.getOriginalFilename() != null
                && !picture.getOriginalFilename().equals("")) {

            //获取图片原始名称，目标要从原始名称中获取文件的扩展名
            String originalFilename = picture.getOriginalFilename();
            //新文件名称
            String fileName_new = UUID.randomUUID()
                    + originalFilename.substring(originalFilename
                    .lastIndexOf("."));
            //新文件
            File newFile = new File("E:\\photo\\upload\\"+fileName_new);
            //将内存中的文件内容写入磁盘上
            picture.transferTo(newFile);
            //更新新文件名到数据库中
            items.setPic(fileName_new);
        }

        itemsService.updateItems(items);
        return "success";
    }

//    批量删除商品信息
    @RequestMapping("/deleteItems")
    public String deleteItems( Integer[] delete_id)throws Exception{
        System.out.println(delete_id);
        return "success";
    }

    //    批量修改商品信息
    @RequestMapping("/updateItems")
    public String updateItems(ItemsQueryVo itemsQueryVo)throws Exception{
        System.out.println(itemsQueryVo);
        return "success";
    }


    @RequestMapping("/query")
    public ModelAndView query() throws Exception {
        ItemsExample example = new ItemsExample();
        ItemsExample.Criteria criteria = example.createCriteria();
        criteria.andIdGreaterThan(1);

        List<Items> itemsList = itemsMapper.selectByExample(example);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }

    @RequestMapping("itemsList")
    public ModelAndView itemsList() {
        //模拟业务层
        List<Items> itemsList = new ArrayList<>();
        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setCreatetime(new Date());
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setCreatetime(new Date());
        items_2.setDetail("iphone6苹果手机！");
        itemsList.add(items_1);
        itemsList.add(items_2);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }


}
