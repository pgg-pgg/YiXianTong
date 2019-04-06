package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.ClassifyTypeDao;
import com.server.yixiantong.domain.ClassifyTypeEntity;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.service.ClassifyTypeEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassifyTypeEbo implements ClassifyTypeEbi {
    @Resource
    public ClassifyTypeDao classifyTypeDao;

    @Override
    public String insertClassifyType(ClassifyTypeEntity classifyTypeEntity) {
        classifyTypeDao.insertClassifyType(classifyTypeEntity);
        ResponseMessage<ClassifyTypeEntity> responseMessage = new ResponseMessage<>(0,"插入成功",classifyTypeEntity);
        return JSON.toJSONString(responseMessage);
    }

    @Override
    public String getAllClassifyType() {
        List<ClassifyTypeEntity> allClassifyType = classifyTypeDao.getAllClassifyType();
        ResponseMessage<List<ClassifyTypeEntity>> responseMessage = new ResponseMessage<>(0,"获取成功",allClassifyType);
        return JSON.toJSONString(responseMessage);
    }
}