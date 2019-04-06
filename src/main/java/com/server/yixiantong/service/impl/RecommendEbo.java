package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.RecommendDao;
import com.server.yixiantong.domain.Recommend;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.service.RecommendEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecommendEbo implements RecommendEbi {
    @Resource
    public RecommendDao recommendDao;

    @Override
    public String insertRecommend(Recommend recommend) {
        recommendDao.insertRecommend(recommend);
        ResponseMessage<Recommend> responseMessage = new ResponseMessage<>(0,"插入成功",recommend);
        return JSON.toJSONString(responseMessage);
    }

    @Override
    public List<Recommend> getRecommendList(int curPage, int pageNum) {
        List<Recommend> recommends = recommendDao.getRecommendList(curPage,pageNum);
        return recommends;
    }

    @Override
    public String getRecommendPageList(int curPage, int pageNum) {
        List<Recommend> recommends = recommendDao.getRecommendList(curPage,pageNum);
        ResponseMessage<List<Recommend>> responseMessage = new ResponseMessage<>(0,"获取成功，当前页码"+curPage,recommends);
        return JSON.toJSONString(responseMessage);
    }
}