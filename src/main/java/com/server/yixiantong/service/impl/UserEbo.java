package com.server.yixiantong.service.impl;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.RegisterInfo;
import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.UserDao;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.domain.User;
import com.server.yixiantong.service.UserEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserEbo implements UserEbi {
    @Resource
    public UserDao userDao;


    @Override
    public String insertUser(User user) {
        if (searchUserByUserName(user.getUser_name())!=null){
            return ResponseMessage.responseNot("注册失败,用户已存在");
        }else {
            userDao.insertUser(user);
            JMessageClient client = new JMessageClient("351cdce416ecc9537ae57345", "ea1abea8443e49fe82553d7e");
            RegisterInfo.Builder builder= RegisterInfo.newBuilder();
            builder.setPassword(user.getUser_pwd());
            builder.setUsername(user.getUser_name());
            builder.setNickname(user.getUser_nick_name());
            RegisterInfo info = builder.build();
            try {
                String res = client.registerUsers(new RegisterInfo[]{info});
                System.out.println(res);
                ResponseMessage<User> message=new ResponseMessage<>(0,"注册成功！",user);
                return JSON.toJSONString(message);
            } catch (APIConnectionException e) {
                System.out.println("Connection error. Should retry later. "+e.getMessage());
            } catch (APIRequestException e) {
                System.out.println("Error response from JPush server. Should review and fix it. "+ e.getMessage());
                System.out.println("HTTP Status: " + e.getStatus());
                System.out.println("Error Message: " + e.getMessage());
            }
        }
        return ResponseMessage.responseNot("注册失败");

    }

    @Override
    public User searchUserById(String id) {
        return userDao.searchUserById(id);
    }

    @Override
    public User searchUserByUserName(String user_name) {
        return userDao.searchUserByUserName(user_name);
    }
}
