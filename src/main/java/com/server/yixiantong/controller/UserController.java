package com.server.yixiantong.controller;


import com.alibaba.fastjson.JSON;;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.domain.User;
import com.server.yixiantong.service.UserEbi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/User")
public class UserController {

    @Resource
    private UserEbi userEbi;

    @RequestMapping(value = "/register", method = { RequestMethod.POST, RequestMethod.GET})
    public String insertUserCon(@RequestBody User user) {
        System.out.println(user.toString());
        String result = userEbi.insertUser(user);
        return result;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String LoginCon(String id, String password) {
        User user = userEbi.searchUserById(id);
        return ResponseMessage.responseNot("密码错误");
    }
}
