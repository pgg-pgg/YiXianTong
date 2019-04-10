package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.ClassifyDescDao;
import com.server.yixiantong.dao.ClassifyTypeDao;
import com.server.yixiantong.dao.GoodsTypeDao;
import com.server.yixiantong.domain.*;
import com.server.yixiantong.service.ClassifyTypeEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassifyTypeEbo implements ClassifyTypeEbi {
    @Resource
    public ClassifyTypeDao classifyTypeDao;

    @Resource
    public ClassifyDescDao classifyDescDao;

    @Resource
    public GoodsTypeDao goodsTypeDao;

    @Override
    public String insertClassifyType(ClassifyTypeEntity classifyTypeEntity) {
        classifyTypeDao.insertClassifyType(classifyTypeEntity);
        ResponseMessage<ClassifyTypeEntity> responseMessage = new ResponseMessage<>(0, "插入成功", classifyTypeEntity);
        return JSON.toJSONString(responseMessage);
    }

    @Override
    public String getAllClassifyType() {
        List<ClassifyTypeEntity> allClassifyType = classifyTypeDao.getAllClassifyType();
        ResponseMessage<List<ClassifyTypeEntity>> responseMessage = new ResponseMessage<>(0, "获取成功", allClassifyType);
        return JSON.toJSONString(responseMessage);
    }

    @Override
    public String getClassifyItemByPosition(int classifyTypeId) {
        List<ClassifyItemEntity> classifyItemEntities = new ArrayList<>();
        List<ClassifyDescEntity> allClassifyDesc = classifyDescDao.getAllClassifyDesc(classifyTypeId);
        for (ClassifyDescEntity classifyDesc : allClassifyDesc) {
            ClassifyItemEntity classifyItemEntity = new ClassifyItemEntity();
            classifyItemEntity.setClassifyDescEntity(classifyDesc);
            List<GoodsTypeEntity> allGoodsType = goodsTypeDao.getAllGoodsType(classifyDesc.getId());
            classifyItemEntity.setGoodsTypeEntities(allGoodsType);
            classifyItemEntity.setPosition(classifyDesc.getId());
            classifyItemEntities.add(classifyItemEntity);
        }
        ResponseMessage<List<ClassifyItemEntity>> responseMessage = new ResponseMessage<>(0,"获取成功",classifyItemEntities);
        return JSON.toJSONString(responseMessage);
    }
}