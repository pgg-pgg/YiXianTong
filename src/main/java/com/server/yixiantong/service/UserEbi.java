package com.server.yixiantong.service;


import com.server.yixiantong.domain.User;

public interface UserEbi {

    /**
     * 注册一个用户
     */
    String insertUser(User user);

    /**
     * 通过id找到一个用户
     * @param id
     * @return
     */
    User searchUserById(String id);

    User searchUserByUserName(String user_name);
}
