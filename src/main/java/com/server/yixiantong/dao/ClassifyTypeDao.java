package com.server.yixiantong.dao;


import com.server.yixiantong.domain.ClassifyTypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClassifyTypeDao {

    /**
     * 添加一个分类
     * POST
     * @return
     */
    void insertClassifyType(ClassifyTypeEntity classifyTypeEntity);
    /**
     * 获取所有分类
     */
    List<ClassifyTypeEntity> getAllClassifyType();
}
