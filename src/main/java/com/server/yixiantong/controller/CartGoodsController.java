package com.server.yixiantong.controller;


import com.alibaba.fastjson.JSON;
import com.server.yixiantong.domain.CartGoods;
import com.server.yixiantong.service.CartGoodsEbi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/CartGoods")
public class CartGoodsController {

    @Resource
    private CartGoodsEbi cartGoodsEbi;

    @RequestMapping(value = "/insertCartGoods", method = {RequestMethod.POST, RequestMethod.GET})
    public String insertCartGoods(@RequestBody CartGoods cartGoods) {
        System.out.println(JSON.toJSON(cartGoods));
        return cartGoodsEbi.insertCartGoods(cartGoods);
    }

    @RequestMapping(value = "/getCartGoodsList", method = {RequestMethod.GET})
    public String getCartGoodsList(String user_name) {
        return cartGoodsEbi.getCartGoodsList(user_name);
    }

    @RequestMapping(value = "/deleteCartGoods", method = {RequestMethod.GET})
    public String deleteCartGoods(int id) {
        return cartGoodsEbi.deleteCartGoods(id);
    }

    @RequestMapping(value = "/deleteCartGoodsList", method = {RequestMethod.POST})
    public String deleteCartGoodsList(@RequestBody List<Integer> paramList) {
        return cartGoodsEbi.deleteCartGoodsList(paramList);
    }

}
