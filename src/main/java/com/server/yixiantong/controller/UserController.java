package com.server.yixiantong.controller;


import com.server.yixiantong.domain.User;
import com.server.yixiantong.service.UserEbi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/User")
public class UserController {

    @Resource
    private UserEbi userEbi;

    @RequestMapping(value = "/register", method = { RequestMethod.POST, RequestMethod.GET})
    public String insertUserCon(@RequestBody User user) {
        System.out.println(user.toString());
        return userEbi.insertUser(user);
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String LoginCon(String user_name, String user_pwd) {
        return userEbi.Login(user_name,user_pwd);
    }

    @RequestMapping(value = "/updateUserInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public String UpdatePwdByIdCon(@RequestBody User user) {
        return userEbi.updateUserInfo(user);
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})
    public String Logout(@RequestBody User user) {
        return userEbi.updateUserState(user);
    }
}
