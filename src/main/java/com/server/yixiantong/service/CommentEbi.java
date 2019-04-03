package com.server.yixiantong.service;



import com.server.yixiantong.domain.Comment;

import java.util.List;

public interface CommentEbi {


    String insertComment(Comment comment);

    List<Comment> getCommentList();
}
