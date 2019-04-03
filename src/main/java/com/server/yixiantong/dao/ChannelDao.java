package com.server.yixiantong.dao;


import com.server.yixiantong.domain.Channel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ChannelDao {

    void insertChannel(Channel channel);

    List<Channel> getChannelList();

}
