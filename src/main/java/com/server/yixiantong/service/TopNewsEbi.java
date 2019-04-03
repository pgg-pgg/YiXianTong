package com.server.yixiantong.service;



import com.server.yixiantong.domain.TopNews;

import java.util.List;

public interface TopNewsEbi {


    String insertTopNews(TopNews topNews);

    List<TopNews> getTopNewsList();
}
