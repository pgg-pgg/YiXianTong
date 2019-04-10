package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.CommentsDao;
import com.server.yixiantong.dao.RecommendDao;
import com.server.yixiantong.domain.Comments;
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

    @Resource
    public CommentsDao commentsDao;

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

    @Override
    public String getRecommendByGoodsName(String goodsName) {
        Recommend recommendByGoodsName = recommendDao.getRecommendByGoodsName(goodsName);
        if (recommendByGoodsName!=null){
            List<Comments> commendsList = commentsDao.getCommentsList(recommendByGoodsName.getId());
            List<Recommend> recommendList = getRecommendList((int) (1 + Math.random() * (5 - 1 + 1)), 5);
            recommendByGoodsName.setComments(commendsList);
            recommendByGoodsName.setRecommends(recommendList);
            ResponseMessage<Recommend> responseMessage = new ResponseMessage<>(0,"获取成功",recommendByGoodsName);
            return JSON.toJSONString(responseMessage);
        }
        return ResponseMessage.responseNot("获取失败");
    }
}