package com.server.yixiantong.controller;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.domain.Comments;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.service.impl.CommentsEbo;
import com.server.yixiantong.service.impl.RecommendEbo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/GoodsDetail")
public class GoodsDetailController {


    @Resource
    private RecommendEbo recommendEbo;

    @Resource
    private CommentsEbo commentsEbo;

    @RequestMapping(value = "/getGoodsDetail", method = {RequestMethod.GET})
    public String getGoodsDetail(String goodsName) {
        return recommendEbo.getRecommendByGoodsName(goodsName);
    }

    @RequestMapping(value = "/getComments", method = {RequestMethod.GET})
    public String getComments(int goodsId) {
        List<Comments> commentsList = commentsEbo.getCommentsList(goodsId);
        ResponseMessage<List<Comments>> responseMessage = new ResponseMessage<>(0,"获取成功",commentsList);
        return JSON.toJSONString(responseMessage);
    }

}
