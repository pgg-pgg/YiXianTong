package com.server.yixiantong.service;



import com.server.yixiantong.domain.Recommend;

import java.util.List;

public interface RecommendEbi {


    String insertRecommend(Recommend recommend);

    List<Recommend> getRecommendList();
}
