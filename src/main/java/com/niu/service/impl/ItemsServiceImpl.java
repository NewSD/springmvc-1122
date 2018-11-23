package com.niu.service.impl;

import com.niu.entity.Items;
import com.niu.mapper.ItemsMapper;
import com.niu.mapper.ItemsMapperCustom;
import com.niu.service.ItemsService;
import com.niu.vo.ItemsQueryVo;
import com.niu.vo.ItemsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ami on 2018/11/22.
 */
@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsVo> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    @Override
    public Items findItemsById(Integer id) throws Exception {
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateItems(Items items) throws Exception {
        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }
}
