package com.niu.controller;

import com.niu.entity.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ami on 2018/11/23.
 */
@Controller
@RequestMapping
public class JsonTestController {

    @RequestMapping("/requestJson")
    @ResponseBody
    public Items requestJson(@RequestBody Items items)throws Exception{

        return items;
    }

    @RequestMapping("/responseJson")
    @ResponseBody
    public Items responseJson(Items items)throws Exception{
        return items;
    }

}
