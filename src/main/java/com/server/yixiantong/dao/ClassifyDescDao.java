package com.server.yixiantong.dao;


import com.server.yixiantong.domain.ClassifyDescEntity;
import com.server.yixiantong.domain.ClassifyTypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClassifyDescDao {

    /**
     * 添加一个分类
     * POST
     * @return
     */
    void insertClassifyDesc(ClassifyDescEntity classifyDescEntity);
    /**
     * 根据分类的id获取所有分类子条目
     */
    List<ClassifyDescEntity> getAllClassifyDesc(int classifyTypeId);
}
