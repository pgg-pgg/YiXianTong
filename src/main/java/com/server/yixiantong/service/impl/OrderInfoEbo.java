package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.CartGoodsDao;
import com.server.yixiantong.dao.OrderInfoDao;
import com.server.yixiantong.dao.OrderGoodsDao;
import com.server.yixiantong.dao.ShipAddressDao;
import com.server.yixiantong.domain.*;
import com.server.yixiantong.service.OrderInfoEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderInfoEbo implements OrderInfoEbi {
    @Resource
    public OrderInfoDao orderInfoDao;

    @Resource
    public OrderGoodsDao orderGoodsDao;

    @Resource
    public ShipAddressDao shipAddressDao;

    @Resource
    public CartGoodsDao cartGoodsDao;


    @Override
    public String addOrder(Order order) {
        List<OrderGoods> orderGoodsList = order.getOrderGoodsList();
        if (orderGoodsList.isEmpty()){
            return ResponseMessage.responseNot("参数错误");
        }else {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setUserName(order.getUserName());
            orderInfo.setOrderStatus(order.getOrderStatus());
            orderInfo.setShipId(order.getShipAddress().getId());
            orderInfo.setPayType(order.getPayType());
            orderInfo.setTotalPrice(order.getTotalPrice());
            orderInfoDao.insert(orderInfo);
            for (OrderGoods orderGoods:orderGoodsList){
                orderGoods.setOrderId(orderInfo.getId());
                orderGoodsDao.insert(orderGoods);
            }
            if (order.getCartGoodsIds()!=null&&order.getCartGoodsIds().size()>0){
                cartGoodsDao.deleteCartGoodsList(order.getCartGoodsIds());
            }
        }
        return ResponseMessage.responseOk();
    }

    @Override
    public String getOrderList(String userName) {
        List<Order> orders = new ArrayList<>();
        List<OrderInfo> orderInfos = orderInfoDao.selectAllOrderList(userName);
        setOrderGoodsList(orders, orderInfos);
        ResponseMessage<List<Order>> message = new ResponseMessage<>(0,"获取成功",orders);
        return JSON.toJSONString(message);
    }

    @Override
    public String getOrderListByStatus(String userName, int orderStatus) {
        List<Order> orders = new ArrayList<>();
        List<OrderInfo> orderInfos = orderInfoDao.selectOrderList(userName,orderStatus);
        if (orderInfos!=null){
            setOrderGoodsList(orders, orderInfos);
        }
        ResponseMessage<List<Order>> message = new ResponseMessage<>(0,"获取成功",orders);
        return JSON.toJSONString(message);
    }

    private void setOrderGoodsList(List<Order> orders, List<OrderInfo> orderInfos) {
        for (OrderInfo orderInfo : orderInfos) {
            Order order = new Order();
            List<OrderGoods> orderGoods = orderGoodsDao.selectGoodsList(orderInfo.getId());
            order.setOrderGoodsList(orderGoods);
            order.setOrderStatus(orderInfo.getOrderStatus());
            order.setPayType(orderInfo.getPayType());
            ShipAddress shipAddress = shipAddressDao.selectByPrimaryKey(orderInfo.getShipId());
            order.setShipAddress(shipAddress);
            order.setTotalPrice(orderInfo.getTotalPrice());
            order.setUserName(orderInfo.getUserName());
            order.setId(orderInfo.getId());
            orders.add(order);
        }
    }

    @Override
    public String updateOrderStatus(int orderStatus, int id) {
        try {
            this.orderInfoDao.updateOrderStatus(orderStatus,id);
            return ResponseMessage.responseOk();
        }catch (Exception e){
            return ResponseMessage.responseNot("更新失败");
        }
    }
}