package com.server.yixiantong.service;


import com.server.yixiantong.domain.ShipAddress;

import java.util.List;

public interface ShipAddressEbi {
    int addShipAddress(ShipAddress paramShipAddress);

    List<ShipAddress> getShipAddress(String userName);

    int modifyShipAddress(ShipAddress paramShipAddress);

    int deleteShipAddress(Integer paramInteger);

    ShipAddress getShipAddressById(Integer paramInteger);

    ShipAddress getShipAddressByStatus();
}
