package com.server.yixiantong.controller;


import com.alibaba.fastjson.JSON;
import com.server.yixiantong.domain.CartGoods;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.domain.ShipAddress;
import com.server.yixiantong.service.CartGoodsEbi;
import com.server.yixiantong.service.ShipAddressEbi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ShipAddress")
public class ShipAddressController {

    @Resource
    private ShipAddressEbi shipAddressEbi;

    @RequestMapping(value = "/addShipAddress", method = {RequestMethod.POST, RequestMethod.GET})
    public String addShipAddress(@RequestBody ShipAddress shipAddress) {
        System.out.println(JSON.toJSON(shipAddress));
        try {
            shipAddressEbi.addShipAddress(shipAddress);
            return ResponseMessage.responseOk();
        }catch (Exception e){
            return ResponseMessage.responseNot("添加地址错误！"+e.getMessage());
        }
    }

    @RequestMapping(value = "/getShipAddress", method = {RequestMethod.GET})
    public String getShipAddress(String userName) {
        List<ShipAddress> shipAddress = shipAddressEbi.getShipAddress(userName);
        if (shipAddress!=null&&shipAddress.size()>=0){
            ResponseMessage<List<ShipAddress>> message = new ResponseMessage<>(0,"获取成功",shipAddress);
            return JSON.toJSONString(message);
        }
        return ResponseMessage.responseNot("获取失败");
    }

    @RequestMapping(value = "/modifyShipAddress", method = {RequestMethod.POST})
    public String modifyShipAddress(@RequestBody ShipAddress shipAddress) {
        try {

            if (shipAddress.getShipIsDefault() == 0){
                ShipAddress shipAddressByStatus = shipAddressEbi.getShipAddressByStatus();
                //设置为默认了，其他置为非默认
                if (shipAddressByStatus!=null){
                    shipAddressByStatus.setShipIsDefault(1);
                    shipAddressEbi.modifyShipAddress(shipAddressByStatus);
                }
            }
            shipAddressEbi.modifyShipAddress(shipAddress);
            return ResponseMessage.responseOk();
        }catch (Exception e){
            return ResponseMessage.responseNot("修改地址错误！"+e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteShipAddress", method = {RequestMethod.GET})
    public String deleteShipAddress(int id) {
        try {
            shipAddressEbi.deleteShipAddress(id);
            return ResponseMessage.responseOk();
        }catch (Exception e){
            return ResponseMessage.responseNot("删除地址错误！"+e.getMessage());
        }
    }

    @RequestMapping(value = "/getShipAddressById", method = {RequestMethod.GET})
    public String getShipAddressById(int id) {
        ShipAddress address = shipAddressEbi.getShipAddressById(id);
        if (address==null){
            return ResponseMessage.responseNot("获取地址错误！");
        }
        ResponseMessage<ShipAddress> message = new ResponseMessage<>(0,"获取成功",address);
        return JSON.toJSONString(message);
    }

}
