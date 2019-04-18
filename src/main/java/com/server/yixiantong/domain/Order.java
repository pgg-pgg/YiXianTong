package com.server.yixiantong.domain;

import java.util.List;


public class Order {
    private Integer id;
    private Integer payType;
    private ShipAddress shipAddress;
    private String totalPrice;
    private Integer orderStatus;
    private String userName;
    private List<OrderGoods> orderGoodsList;
    private List<Integer> cartGoodsIds;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPayType() {
        return this.payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public ShipAddress getShipAddress() {
        return this.shipAddress;
    }

    public void setShipAddress(ShipAddress shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderGoods> getOrderGoodsList() {
        return this.orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderGoods> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Integer> getCartGoodsIds() {
        return cartGoodsIds;
    }

    public void setCartGoodsIds(List<Integer> cartGoodsIds) {
        this.cartGoodsIds = cartGoodsIds;
    }
}