package com.server.yixiantong.dao;


import com.server.yixiantong.domain.GoodsTypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsTypeDao {

    /**
     * 添加一个分类
     * POST
     * @return
     */
    void insertGoodsType(GoodsTypeEntity goodsTypeEntity);
    /**
     * 根据分类的id获取所有分类子条目
     */
    List<GoodsTypeEntity> getAllGoodsType(int classifyDescId);
}
