package com.server.yixiantong.dao;


import com.server.yixiantong.domain.TopNews;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TopNewsDao {

    void insertTopNews(TopNews topNews);

    List<TopNews> getTopNewsList();

}
