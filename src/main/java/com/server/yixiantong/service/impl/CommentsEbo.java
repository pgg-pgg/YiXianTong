package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.CommentsDao;
import com.server.yixiantong.domain.Comments;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.service.CommentsEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentsEbo implements CommentsEbi {
    @Resource
    public CommentsDao commentsDao;

    @Override
    public String insertComment(Comments comment) {
        commentsDao.insertComments(comment);
        ResponseMessage<Comments> responseMessage = new ResponseMessage<>(0,"插入成功",comment);
        return JSON.toJSONString(responseMessage);
    }

    @Override
    public List<Comments> getCommentsList(int goodsId) {
        List<Comments> comments = commentsDao.getCommentsList(goodsId);
        return comments;
    }
}