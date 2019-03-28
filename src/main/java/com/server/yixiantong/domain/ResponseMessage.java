package com.server.yixiantong.domain;

import com.alibaba.fastjson.JSON;

public  class ResponseMessage<E> {
    private int code;
    private String message;
    private E data;

    public ResponseMessage(int code, String message, E data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static String responseOk(){
        return JSON.toJSONString(new ResponseMessage(0, "成功", null));
    }
    public static String responseNot(String desp){
        return JSON.toJSONString(new ResponseMessage(-1, desp, null));
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
