package com.mryang.model;

import com.mryang.globel.User;

import java.util.ArrayList;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName UserModel.java
 * @Description TODO 用户模型层
 * @createTime 2021年05月10日 17:11:00
 */
public class UserModel {

    /**
     * 对用户信息进行校对
     * @param loginUser 拿到的不完整的用户信息（包含必要信息）
     * @param userList 用户信息集合
     * @return  校对成功 完整的用户信息，失败 null
     */
    public User Login(User loginUser, ArrayList<User> userList) {
//        System.out.println(loginUser);
        for (User user : userList){
            if(loginUser.getUserName().equals(user.getUserName())){ // 用户名校对成功
                if (loginUser.getPassword().equals(user.getPassword())){ // 密码校对成功
                    return user;
                }
            }
        }
        return null;
    }
}
