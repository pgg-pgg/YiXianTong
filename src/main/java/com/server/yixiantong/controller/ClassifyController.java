package com.server.yixiantong.controller;


import com.server.yixiantong.service.ClassifyTypeEbi;
import com.server.yixiantong.service.HomeEbi;
import com.server.yixiantong.service.RecommendEbi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Classify")
public class ClassifyController {


    @Resource
    private ClassifyTypeEbi classifyTypeEbi;

    @RequestMapping(value = "/getAllClassifyData", method = {RequestMethod.GET})
    public String getAllClassifyData() {
        return classifyTypeEbi.getAllClassifyType();
    }
}
