package com.server.yixiantong.domain;


public class TopNews {

    private int id;
    private String leftTopImageUrl;
    private String topName;
    private String topDesc;
    private String goodsUrlLeft;
    private String goodsUrlRight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeftTopImageUrl() {
        return leftTopImageUrl;
    }

    public void setLeftTopImageUrl(String leftTopImageUrl) {
        this.leftTopImageUrl = leftTopImageUrl;
    }

    public String getTopName() {
        return topName;
    }

    public void setTopName(String topName) {
        this.topName = topName;
    }

    public String getTopDesc() {
        return topDesc;
    }

    public void setTopDesc(String topDesc) {
        this.topDesc = topDesc;
    }

    public String getGoodsUrlLeft() {
        return goodsUrlLeft;
    }

    public void setGoodsUrlLeft(String goodsUrlLeft) {
        this.goodsUrlLeft = goodsUrlLeft;
    }

    public String getGoodsUrlRight() {
        return goodsUrlRight;
    }

    public void setGoodsUrlRight(String goodsUrlRight) {
        this.goodsUrlRight = goodsUrlRight;
    }
}
