package com.niu.mapper;

import com.niu.entity.Items;
import com.niu.vo.ItemsQueryVo;
import com.niu.vo.ItemsVo;

import java.util.List;

/**
 * Created by ami on 2018/11/22.
 */
public interface ItemsMapperCustom {

    List<ItemsVo> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;





}
