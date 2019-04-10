package com.server.yixiantong.service;

import com.server.yixiantong.domain.GoodsTypeEntity;

public interface GoodsTypeEbi {
    String insertGoodsType(GoodsTypeEntity goodsTypeEntity);

    String getAllGoodsType(int classifyDescId);
}
