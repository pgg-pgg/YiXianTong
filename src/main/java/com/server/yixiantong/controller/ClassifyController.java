package com.server.yixiantong.controller;


import com.server.yixiantong.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Classify")
public class ClassifyController {


    @Resource
    private ClassifyTypeEbi classifyTypeEbi;

    @Resource
    private ClassifyDescEbi classifyDescEbi;

    @Resource
    private GoodsTypeEbi goodsTypeEbi;

    @RequestMapping(value = "/getAllClassifyData", method = {RequestMethod.GET})
    public String getAllClassifyData() {
        return classifyTypeEbi.getAllClassifyType();
    }


    @RequestMapping(value = "/getAllClassifyDescData", method = {RequestMethod.GET})
    public String getAllClassifyDescData(int classifyTypeId) {
        return classifyDescEbi.getAllClassifyDesc(classifyTypeId);
    }

    @RequestMapping(value = "/getAllGoodsTypeData", method = {RequestMethod.GET})
    public String getAllGoodsTypeData(int classifyDescId) {
        return goodsTypeEbi.getAllGoodsType(classifyDescId);
    }

    @RequestMapping(value = "/getClassifyItemEntities", method = {RequestMethod.GET})
    public String getClassifyItemEntities(int classifyDescId) {
        return classifyTypeEbi.getClassifyItemByPosition(classifyDescId);
    }
}
