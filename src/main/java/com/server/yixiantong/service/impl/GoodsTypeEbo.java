package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.GoodsTypeDao;
import com.server.yixiantong.domain.GoodsTypeEntity;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.service.GoodsTypeEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsTypeEbo implements GoodsTypeEbi {
    @Resource
    public GoodsTypeDao goodsTypeDao;


    @Override
    public String insertGoodsType(GoodsTypeEntity goodsTypeEntity) {
        goodsTypeDao.insertGoodsType(goodsTypeEntity);
        ResponseMessage<GoodsTypeEntity> responseMessage = new ResponseMessage<>(0,"插入成功",goodsTypeEntity);
        return JSON.toJSONString(responseMessage);
    }

    @Override
    public String getAllGoodsType(int classifyDescId) {
        List<GoodsTypeEntity> allClassifyType = goodsTypeDao.getAllGoodsType(classifyDescId);
        ResponseMessage<List<GoodsTypeEntity>> responseMessage = new ResponseMessage<>(0,"获取成功",allClassifyType);
        return JSON.toJSONString(responseMessage);
    }
}