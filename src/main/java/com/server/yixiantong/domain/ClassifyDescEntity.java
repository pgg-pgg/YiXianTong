package com.server.yixiantong.domain;

public class ClassifyDescEntity {

    private int id;
    private int classifyTypeId;
    private String imageUrl;
    private String typeName;
    private int goodsTypeId;

    public int getClassifyTypeId() {
        return classifyTypeId;
    }

    public void setClassifyTypeId(int classifyTypeId) {
        this.classifyTypeId = classifyTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(int goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }
}
