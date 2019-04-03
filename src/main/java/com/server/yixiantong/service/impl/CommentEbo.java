package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.CommentDao;
import com.server.yixiantong.domain.Comment;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.service.CommentEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentEbo implements CommentEbi {
    @Resource
    public CommentDao commentDao;

    @Override
    public String insertComment(Comment comment) {
        commentDao.insertComment(comment);
        ResponseMessage<Comment> responseMessage = new ResponseMessage<>(0,"插入成功",comment);
        return JSON.toJSONString(responseMessage);
    }

    @Override
    public List<Comment> getCommentList() {
        List<Comment> comments = commentDao.getCommentList();
        return comments;
    }
}