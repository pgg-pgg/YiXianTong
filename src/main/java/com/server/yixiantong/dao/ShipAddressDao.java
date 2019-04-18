package com.server.yixiantong.dao;


import com.server.yixiantong.domain.ShipAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShipAddressDao {
    int deleteByPrimaryKey(Integer paramInteger);

    int insert(ShipAddress paramShipAddress);

    int insertSelective(ShipAddress paramShipAddress);

    ShipAddress selectByPrimaryKey(Integer paramInteger);

    int updateByPrimaryKeySelective(ShipAddress paramShipAddress);

    int updateByPrimaryKey(ShipAddress paramShipAddress);

    List<ShipAddress> selectShipAddressByUserId(String userName);

    ShipAddress selectShipAddressByStatus();
}
