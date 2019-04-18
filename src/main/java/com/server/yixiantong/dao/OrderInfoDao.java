package com.server.yixiantong.dao;

import com.server.yixiantong.domain.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface OrderInfoDao {

    int deleteByPrimaryKey(Integer paramInteger);

    int insert(OrderInfo paramOrderInfo);

    int insertSelective(OrderInfo paramOrderInfo);

    OrderInfo selectByPrimaryKey(Integer paramInteger);

    int updateByPrimaryKeySelective(OrderInfo paramOrderInfo);

    int updateByPrimaryKey(OrderInfo paramOrderInfo);

    List<OrderInfo> selectOrderList(@Param("userName")String userName, @Param("orderStatus") int orderStatus);

    List<OrderInfo> selectAllOrderList(String userName);

    void updateOrderStatus(@Param("orderStatus") int orderStatus,@Param("id") int id);
}
