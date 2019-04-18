package com.server.yixiantong.dao;

import com.server.yixiantong.domain.OrderGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderGoodsDao {

    int deleteByPrimaryKey(Integer paramInteger);

    int insert(OrderGoods paramOrderGoods);

    int insertSelective(OrderGoods paramOrderGoods);

    OrderGoods selectByPrimaryKey(Integer paramInteger);

    int updateByPrimaryKeySelective(OrderGoods paramOrderGoods);

    int updateByPrimaryKey(OrderGoods paramOrderGoods);

    List<OrderGoods> selectGoodsList(Integer orderId);

}
