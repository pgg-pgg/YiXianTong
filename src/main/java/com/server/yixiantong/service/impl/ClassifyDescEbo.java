package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.ClassifyDescDao;
import com.server.yixiantong.domain.ClassifyDescEntity;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.service.ClassifyDescEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassifyDescEbo implements ClassifyDescEbi {
    @Resource
    public ClassifyDescDao classifyDescDao;


    @Override
    public String insertClassifyType(ClassifyDescEntity classifyDescEntity) {
        classifyDescDao.insertClassifyDesc(classifyDescEntity);
        ResponseMessage<ClassifyDescEntity> responseMessage = new ResponseMessage<>(0,"插入成功",classifyDescEntity);
        return JSON.toJSONString(responseMessage);
    }

    @Override
    public String getAllClassifyDesc(int classifyTypeId) {
        List<ClassifyDescEntity> allClassifyType = classifyDescDao.getAllClassifyDesc(classifyTypeId);
        ResponseMessage<List<ClassifyDescEntity>> responseMessage = new ResponseMessage<>(0,"获取成功",allClassifyType);
        return JSON.toJSONString(responseMessage);
    }
}