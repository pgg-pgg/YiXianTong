package com.server.yixiantong.controller;


import com.server.yixiantong.service.HomeEbi;
import com.server.yixiantong.service.RecommendEbi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Home")
public class HomeController {


    @Resource
    private HomeEbi homeEbi;

    @Resource
    private RecommendEbi recommendEbi;

    @RequestMapping(value = "/getHomeData", method = {RequestMethod.GET})
    public String getHomeData(int curPage, int pageNum) {
        return homeEbi.getHomeEntity(curPage,pageNum);
    }

    @RequestMapping(value = "/getRecommendData", method = {RequestMethod.GET})
    public String getRecommendData(int curPage, int pageNum) {
        return recommendEbi.getRecommendPageList(curPage,pageNum);
    }


}
