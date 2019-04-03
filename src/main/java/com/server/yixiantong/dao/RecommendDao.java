package com.server.yixiantong.dao;


import com.server.yixiantong.domain.Recommend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RecommendDao {

    void insertRecommend(Recommend recommend);

    List<Recommend> getRecommendList();

}
