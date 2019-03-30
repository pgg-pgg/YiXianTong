package com.server.yixiantong.service.impl;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.RegisterInfo;
import cn.jmessage.api.common.model.UserPayload;
import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.UserDao;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.domain.User;
import com.server.yixiantong.service.UserEbi;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UserEbo implements UserEbi {
    @Resource
    public UserDao userDao;
    JMessageClient client = new JMessageClient("351cdce416ecc9537ae57345", "ea1abea8443e49fe82553d7e");


    @Override
    public String insertUser(User user) {
        if (searchUserByUserName(user.getUser_name())!=null){
            return ResponseMessage.responseNot("注册失败,用户已存在");
        }else {

            if (setUserIcon(user)) return ResponseMessage.responseNot("注册失败");

            String message = registerToJGIM(user);

            if (message != null) return message;
        }
        return ResponseMessage.responseNot("注册失败");

    }

    /**
     * 在极光IM上注册用户
     * @param user
     * @return
     */
    private String registerToJGIM(User user) {
        RegisterInfo.Builder builder= RegisterInfo.newBuilder();
        builder.setPassword(user.getUser_pwd());
        builder.setUsername(user.getUser_name());
        builder.setNickname(user.getUser_nick_name());
        RegisterInfo info = builder.build();
        try {
            String res = client.registerUsers(new RegisterInfo[]{info});
            System.out.println(res);
            user.setUser_state("1");
            userDao.insertUser(user);

            ResponseMessage<User> message=new ResponseMessage<>(0,"注册成功！",user);
            return JSON.toJSONString(message);
        } catch (APIConnectionException e) {
            System.out.println("Connection error. Should retry later. "+e.getMessage());
        } catch (APIRequestException e) {
            System.out.println("Error response from JPush server. Should review and fix it. "+ e.getMessage());
            System.out.println("HTTP Status: " + e.getStatus());
            System.out.println("Error Message: " + e.getMessage());
        }
        return null;
    }

    /**
     * 获取传递过来的头像base64码，解析并存储到本地
     * @param user
     * @return
     */
    private boolean setUserIcon(User user) {
        String s1="/Users/pengganggui/Documents/idea_project/YiXianTong/src/main/resources/static/image";
        String photo=user.getUser_name()+".jpg";
        FileOutputStream fos = null;
        byte[] buffer;
        try {
            buffer = new BASE64Decoder().decodeBuffer(user.getUser_icon());
            user.setUser_icon("image/"+photo);

            //对android传过来的图片字符串进行解码
            File destDir = new File(s1);
            if(!destDir.exists()) destDir.mkdir();
            fos = new FileOutputStream(new File(destDir,photo));   //保存图片
            fos.write(buffer);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return true;
        }
        return false;
    }

    @Override
    public User searchUserById(String id) {
        return userDao.searchUserById(id);
    }

    @Override
    public User searchUserByUserName(String user_name) {
        return userDao.searchUserByUserName(user_name);
    }

    @Override
    public String Login(String user_name,String user_pwd){
        User user = searchUserByUserName(user_name);
        if (user==null){
            return ResponseMessage.responseNot("登录失败，用户不存在");
        }else {
            if (!user.getUser_pwd().equals(user_pwd)){
                return ResponseMessage.responseNot("登录失败，密码错误");
            }else {
                user.setUser_state("1");
                updateUserState(user);
                ResponseMessage<User> message=new ResponseMessage<>(0,"登录成功！",user);
                return JSON.toJSONString(message);
            }
        }
    }


    @Override
    public String updateUserInfo(User user) {
        if (searchUserByUserName(user.getUser_name())==null){
            return ResponseMessage.responseNot("更新失败，用户不存在");
        }else {
            UserPayload.Builder build = checkUpdateInfo(user);
            UserPayload payload= build.build();
            try {
                client.updateUserInfo(user.getUser_name(),payload);
                userDao.UpdateUserInfo(user);
                ResponseMessage<User> message=new ResponseMessage<>(0,"更新成功！",user);
                return JSON.toJSONString(message);
            } catch (APIConnectionException e) {
                e.printStackTrace();
                return ResponseMessage.responseNot("更新失败"+e.getMessage());
            } catch (APIRequestException e) {
                e.printStackTrace();
                return ResponseMessage.responseNot("更新失败"+e.getMessage());
            }
        }
    }

    private UserPayload.Builder checkUpdateInfo(User user) {
        String user_icon = user.getUser_icon();
        String user_nick_name = user.getUser_nick_name();
        String user_sign = user.getUser_sign();
        String user_identity_card = user.getUser_identity_card();
        String user_real_name = user.getUser_real_name();
        String user_mobile = user.getUser_mobile();
        UserPayload.Builder build = UserPayload.newBuilder();

        if (user_icon!=null&&!user_icon.equals("")){
            setUserIcon(user);
        }else {
            user.setUser_icon(null);
        }
        if (user_nick_name!=null&&!user_nick_name.equals("")){
            build.setNickname(user_nick_name);
        }else {
            user.setUser_nick_name(null);
        }

        if (user_sign!=null&&!user_sign.equals("")){
            build.setSignature(user_sign);
        }else {
            user.setUser_sign(null);
        }

        if (user_identity_card==null||user_identity_card.equals("")){
            user.setUser_identity_card(null);
        }

        if (user_real_name==null||user_real_name.equals("")){
            user.setUser_real_name(null);
        }

        if (user_mobile==null||user_mobile.equals("")){
            user.setUser_mobile(null);
        }
        return build;
    }


    @Override
    public String updateUserState(User user) {
        if (searchUserByUserName(user.getUser_name())==null){
            return ResponseMessage.responseNot("更新失败，用户不存在");
        }else {
            user.getUser_state();
            userDao.UpdateUserState(user);
            ResponseMessage<User> message=new ResponseMessage<>(0,"更新成功！",user);
            return JSON.toJSONString(message);
        }
    }
}
