package com.server.yixiantong.dao;


import com.server.yixiantong.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {

    void insertComment(Comment comment);

    List<Comment> getCommentList();

}
