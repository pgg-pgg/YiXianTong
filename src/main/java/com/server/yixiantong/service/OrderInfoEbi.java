package com.server.yixiantong.service;



import com.server.yixiantong.domain.Order;
import com.server.yixiantong.domain.OrderGoods;
import com.server.yixiantong.domain.OrderInfo;

import java.util.List;

public interface OrderInfoEbi {

    /**
     * 添加一个订单
     * @param order
     * @return
     */
    String addOrder(Order order);

    /**
     * 获取一个用户的所有订单
     * @param userName
     * @return
     */
    String getOrderList(String userName);


    /**
     * 根据订单状态获取订单
     * @param userName
     * @param orderStatus
     * @return
     */
    String getOrderListByStatus(String userName,int orderStatus);

    /**
     * 更新订单状态
     * @param orderStatus
     * @param id
     * @return
     */
    String updateOrderStatus(int orderStatus,int id);

}
