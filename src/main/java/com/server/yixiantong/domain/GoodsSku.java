package com.server.yixiantong.domain;

import java.util.List;

public class GoodsSku {
    private int id;
    private int goods_id;
    private String goods_sku_title;
    private String goods_sku_content;
    private List<String> skuContent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_sku_title() {
        return goods_sku_title;
    }

    public void setGoods_sku_title(String goods_sku_title) {
        this.goods_sku_title = goods_sku_title;
    }

    public String getGoods_sku_content() {
        return goods_sku_content;
    }

    public void setGoods_sku_content(String goods_sku_content) {
        this.goods_sku_content = goods_sku_content;
    }

    public List<String> getSkuContent() {
        return skuContent;
    }

    public void setSkuContent(List<String> skuContent) {
        this.skuContent = skuContent;
    }
}
