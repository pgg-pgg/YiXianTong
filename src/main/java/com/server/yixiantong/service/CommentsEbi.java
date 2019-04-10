package com.server.yixiantong.service;



import com.server.yixiantong.domain.Comments;

import java.util.List;

public interface CommentsEbi {


    String insertComment(Comments comments);

    List<Comments> getCommentsList(int goodsId);
}
