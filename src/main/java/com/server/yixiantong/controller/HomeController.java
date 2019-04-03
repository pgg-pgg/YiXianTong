package com.server.yixiantong.controller;


import com.server.yixiantong.service.HomeEbi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Home")
public class HomeController {


    @Resource
    private HomeEbi homeEbi;

    @RequestMapping(value = "/getHomeData", method = {RequestMethod.GET})
    public String getHomeData() {
        return homeEbi.getHomeEntity();
    }

}
