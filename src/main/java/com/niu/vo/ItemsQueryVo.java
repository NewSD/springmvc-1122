package com.niu.vo;

import java.util.List;

/**
 * Created by ami on 2018/11/22.
 */
public class ItemsQueryVo {

    private ItemsVo itemsVo;

    //批量提交的商品信息
    private List<ItemsVo> itemsVoList;

    public List<ItemsVo> getItemsVoList() {
        return itemsVoList;
    }

    public void setItemsVoList(List<ItemsVo> itemsVoList) {
        this.itemsVoList = itemsVoList;
    }

    public ItemsVo getItemsVo() {
        return itemsVo;
    }

    public void setItemsVo(ItemsVo itemsVo) {
        this.itemsVo = itemsVo;
    }
}
