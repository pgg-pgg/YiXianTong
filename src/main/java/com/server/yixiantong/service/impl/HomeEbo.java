package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.*;
import com.server.yixiantong.domain.*;
import com.server.yixiantong.service.HomeEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeEbo implements HomeEbi {
    @Resource
    public BannerDao bannerDao;

    @Resource
    public ChannelDao channelDao;

    @Resource
    public CommentDao commentDao;


    @Resource
    public RecommendDao recommendDao;

    @Resource
    public TopNewsDao topNewsDao;

    @Override
    public String getHomeEntity(int curPage, int pageNum) {
        List<Banner> bannerList = bannerDao.getBannerList();
        List<Channel> channelList = channelDao.getChannelList();
        List<Comment> commentList = commentDao.getCommentList();
        List<Recommend> recommendList = recommendDao.getRecommendList(curPage,pageNum);
        List<TopNews> topNewsList = topNewsDao.getTopNewsList();
        if (bannerList==null||channelList==null||commentList==null||recommendList==null||topNewsList==null){
            return ResponseMessage.responseNot("获取数据失败");
        }
        HomeEntity entity = new HomeEntity();
        entity.setBannerEntities(bannerList);
        entity.setChannelEntities(channelList);
        entity.setCommentEntities(commentList);
        entity.setRecommendEntities(recommendList);
        entity.setTopNewsEntities(topNewsList);
        ResponseMessage<HomeEntity> responseMessage = new ResponseMessage<>(0,"首页数据已发送",entity);

        return JSON.toJSONString(responseMessage);
    }
}