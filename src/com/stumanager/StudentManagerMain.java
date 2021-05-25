package com.stumanager;

import com.stumanager.controller.UserController;
import com.stumanager.globel.User;
import com.stumanager.view.UserPage;

import java.sql.SQLException;

/**
 * @author Genius
 * @version 1.0.0 数据库版
 * @ClassName StudentManagerMain.java
 * @Description TODO 学生管理系统的主方法  // mysql数据库版
 * @createTime 2021年05月06日 16:17:00
 */
public class StudentManagerMain {
    public static void main(String[] args) throws SQLException {

        // 定义一个用户控制器对象
        UserController uc = new UserController();

        // 用户登录与注册
        int operation = UserPage.userWelcome();
        User user = uc.Operation(operation);
        if (null != user)
            UserPage.userActionSuccess("欢迎用户 " + user.getUserName() +" 回来！");
        else{
            UserPage.userActionFailed("用户操作失败！");
            System.exit(-1); // 自定义退出码
        }
        // 增删改查
        while(true){
            uc.AccessControl(user);
        }
    }
}
