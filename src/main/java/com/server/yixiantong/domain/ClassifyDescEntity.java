package com.server.yixiantong.domain;

public class ClassifyDescEntity {

    private int id;
    private int classifyTypeId;
    private String typeName;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
