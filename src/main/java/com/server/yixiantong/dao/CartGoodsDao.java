package com.server.yixiantong.dao;


import com.server.yixiantong.domain.CartGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CartGoodsDao {

    void insertCartGoods(CartGoods cartGoods);

    List<CartGoods> getCartGoodsList(String user_name);

    void deleteCartGoods(int id);

    CartGoods getCartGoods(int id);

    void deleteCartGoodsList(List<Integer> paramList);
}
