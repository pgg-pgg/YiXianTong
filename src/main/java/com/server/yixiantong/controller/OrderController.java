package com.server.yixiantong.controller;


import com.server.yixiantong.domain.*;
import com.server.yixiantong.service.OrderInfoEbi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Resource
    private OrderInfoEbi orderInfoEbi;

    @RequestMapping(value = "/addOrder", method = { RequestMethod.POST, RequestMethod.GET})
    public String addOrder(@RequestBody Order order) {
        System.out.println(order.toString());
        return orderInfoEbi.addOrder(order);
    }


    @RequestMapping(value = "/getOrderList", method = { RequestMethod.GET})
    public String addOrder(String userName) {
        return orderInfoEbi.getOrderList(userName);
    }

    @RequestMapping(value = "/getOrderListByStatus", method = { RequestMethod.GET})
    public String getOrderListByStatus(String userName,int orderStatus) {
        return orderInfoEbi.getOrderListByStatus(userName,orderStatus);
    }

    @RequestMapping(value = "/updateOrderStatus", method = { RequestMethod.GET})
    public String updateOrderStatus(int orderStatus,int id) {
        return orderInfoEbi.updateOrderStatus(orderStatus,id);
    }


}
