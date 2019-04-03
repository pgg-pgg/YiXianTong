package com.server.yixiantong.service;

import com.server.yixiantong.domain.Channel;

import java.util.List;

public interface ChannelEbi {

    String insertChannel(Channel banner);

    List<Channel> getChannelList();
}
