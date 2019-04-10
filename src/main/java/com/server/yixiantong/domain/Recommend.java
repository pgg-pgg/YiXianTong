package com.server.yixiantong.domain;

import java.util.List;

/**
 * 为您推荐实体类
 */
public class Recommend {

    private int id;
    //商品轮播图url
    private String goodsBannerUrl;
    //商品图片url
    private String goodsImageUrl;
    //商品名称
    private String goodsName;
    //商品价格
    private String goodsPrice;

    private String goodsOldPrice;
    //商品标签 1 多图   2 认证  3 牛商   0代表没有这个标签，不为0则代表有
    private String goodsLabel;
    //商家地址
    private String address;
    //商家名
    private String manName;
    //发布时间
    private String releaseTime;

    private String goodsDesc;

    private List<Comments> comments;
    private List<Recommend> recommends;
    private String goodsDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsImageUrl() {
        return goodsImageUrl;
    }

    public void setGoodsImageUrl(String goodsImageUrl) {
        this.goodsImageUrl = goodsImageUrl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsLabel() {
        return goodsLabel;
    }

    public void setGoodsLabel(String goodsLabel) {
        this.goodsLabel = goodsLabel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsBannerUrl() {
        return goodsBannerUrl;
    }

    public void setGoodsBannerUrl(String goodsBannerUrl) {
        this.goodsBannerUrl = goodsBannerUrl;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public List<Recommend> getRecommends() {
        return recommends;
    }

    public void setRecommends(List<Recommend> recommends) {
        this.recommends = recommends;
    }

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public String getGoodsOldPrice() {
        return goodsOldPrice;
    }

    public void setGoodsOldPrice(String goodsOldPrice) {
        this.goodsOldPrice = goodsOldPrice;
    }
}
