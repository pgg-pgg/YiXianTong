package com.server.yixiantong.dao;


import com.server.yixiantong.domain.GoodsSku;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsSkuDao {

    void insertGoodsSku(GoodsSku goodsSku);

    List<GoodsSku> getGoodsSkuByGoodsId(int goods_id);
}
