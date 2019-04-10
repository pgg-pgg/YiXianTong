package com.server.yixiantong.dao;


import com.server.yixiantong.domain.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentsDao {

    void insertComments(Comments comments);

    List<Comments> getCommentsList(int goodsId);

}
