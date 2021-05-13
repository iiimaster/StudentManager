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
    private static int userRegID = 3;

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

    /**
     * 判断用户名是否存在
     * @param userName 要判断的用户名
     * @param userList 用户信息集合
     * @return true 存在，false 不存在
     */
    public boolean userNameExists(String userName, ArrayList<User> userList) {
        for (User user : userList){
            if(userName.equals(user.getUserName())){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取完整用户信息
     * @param regUser 不完整的用户信息
     * @param userList 用户信息集合
     * @return 完整用户信息
     */
    public User Registered(User regUser, ArrayList<User> userList) {
        regUser.setId(userRegID++);
        regUser.setStatus("1"); // 0 管理员 1 普通用户（注册只能是普通用户）
        // 将用户完整信息添加到用户信息集合中
        userList.add(regUser);
        // 查询已注册的用户(测试)
//        System.out.println(userList);
        return regUser;
    }
}
