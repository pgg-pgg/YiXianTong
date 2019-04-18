package com.server.yixiantong.service;


import com.server.yixiantong.domain.CartGoods;

import java.util.List;

public interface CartGoodsEbi {

    String insertCartGoods(CartGoods cartGoods);

    String getCartGoodsList(String user_name);

    String deleteCartGoods(int id);

    String deleteCartGoodsList(List<Integer> paramList);
}
