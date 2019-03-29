package com.server.yixiantong.dao;


import com.server.yixiantong.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    /**
     * 注册用户
     * POST
     * @return
     */
    void insertUser(User user);
    /**
     * 得到一个用户
     */
    User searchUserById(String id);

    /**
     * 根据用户名查询用户
     */
    User searchUserByUserName(String user_name);

    void UpdateUserInfo(User user);

    void UpdateUserState(User user);
}
