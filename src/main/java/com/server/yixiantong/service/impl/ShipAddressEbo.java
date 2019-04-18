package com.server.yixiantong.service.impl;

import com.server.yixiantong.dao.ShipAddressDao;
import com.server.yixiantong.domain.ShipAddress;
import com.server.yixiantong.service.ShipAddressEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShipAddressEbo implements ShipAddressEbi {
    @Resource
    public ShipAddressDao shipAddressDao;


    @Override
    public int addShipAddress(ShipAddress model) {
        return this.shipAddressDao.insert(model);
    }

    @Override
    public List<ShipAddress> getShipAddress(String userName) {
        return this.shipAddressDao.selectShipAddressByUserId(userName);
    }

    @Override
    public int modifyShipAddress(ShipAddress model) {
        return this.shipAddressDao.updateByPrimaryKeySelective(model);
    }

    @Override
    public int deleteShipAddress(Integer id) {
        return this.shipAddressDao.deleteByPrimaryKey(id);
    }

    @Override
    public ShipAddress getShipAddressById(Integer id) {
        return this.shipAddressDao.selectByPrimaryKey(id);
    }

    @Override
    public ShipAddress getShipAddressByStatus() {
        return this.shipAddressDao.selectShipAddressByStatus();
    }
}