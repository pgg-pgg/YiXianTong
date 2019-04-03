package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.TopNewsDao;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.domain.TopNews;
import com.server.yixiantong.service.TopNewsEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TopNewsEbo implements TopNewsEbi {
    @Resource
    public TopNewsDao topNewsDao;

    @Override
    public String insertTopNews(TopNews topNews) {
        topNewsDao.insertTopNews(topNews);
        ResponseMessage<TopNews> responseMessage = new ResponseMessage<>(0,"插入成功",topNews);
        return JSON.toJSONString(responseMessage);
    }

    @Override
    public List<TopNews> getTopNewsList() {
        List<TopNews> topNewsList = topNewsDao.getTopNewsList();
        return topNewsList;
    }
}