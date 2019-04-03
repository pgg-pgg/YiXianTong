package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.ChannelDao;
import com.server.yixiantong.domain.Channel;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.service.ChannelEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChannelEbo implements ChannelEbi {
    @Resource
    public ChannelDao channelDao;

    @Override
    public String insertChannel(Channel channel) {
        channelDao.insertChannel(channel);
        ResponseMessage<Channel> responseMessage = new ResponseMessage<>(0,"插入成功",channel);
        return JSON.toJSONString(responseMessage);
    }

    @Override
    public List<Channel> getChannelList() {
        List<Channel> channels = channelDao.getChannelList();
        return channels;
    }
}