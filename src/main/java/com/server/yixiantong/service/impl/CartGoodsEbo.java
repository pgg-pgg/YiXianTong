package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.CartGoodsDao;
import com.server.yixiantong.domain.CartGoods;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.service.CartGoodsEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartGoodsEbo implements CartGoodsEbi {
    @Resource
    public CartGoodsDao cartGoodsDao;

    @Override
    public String insertCartGoods(CartGoods cartGoods) {
        try {
            cartGoodsDao.insertCartGoods(cartGoods);
            ResponseMessage<CartGoods> cartGoodsResponseMessage =new ResponseMessage<>(0,"获取成功",cartGoods);
            return JSON.toJSONString(cartGoodsResponseMessage);
        }catch (Exception e){
            return ResponseMessage.responseNot("添加购物车商品失败");
        }
    }

    @Override
    public String getCartGoodsList(String user_name) {
        List<CartGoods> cartGoodsList = cartGoodsDao.getCartGoodsList(user_name);
        if (cartGoodsList.size()>=0){
            ResponseMessage<List<CartGoods>> message =new ResponseMessage<>(0,"获取成功",cartGoodsList);
            return JSON.toJSONString(message);
        }
        return ResponseMessage.responseNot("获取失败");
    }

    @Override
    public String deleteCartGoods(int id) {
        cartGoodsDao.deleteCartGoods(id);
        return ResponseMessage.responseOk();
    }

    @Override
    public String deleteCartGoodsList(List<Integer> paramList) {
        cartGoodsDao.deleteCartGoodsList(paramList);
        return ResponseMessage.responseOk();
    }
}