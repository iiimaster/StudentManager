package com.stumanager.controller;

import com.stumanager.globel.User;
import com.stumanager.model.UserModel;
import com.stumanager.view.Stupage;
import com.stumanager.view.UserPage;

import java.sql.SQLException;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO 用户控制层
 * @createTime 2021年05月10日 17:11:00
 */
public class UserController {

    private UserModel userModel = new UserModel();
    private StuController stuController = new StuController();

    /**
     * 用户功能调度方法 数据库版
     * @param operation
     * @return
     */
    public User Operation(int operation) throws SQLException {
        User user = null;
        switch(operation){
            case 1:
                System.out.println("登录！");
                // 通过页面获取一个要登录的用户信息(不完整)
                User loginUser = UserPage.getLoginUser();
//                System.out.println(loginUser);
                // 拿到这个用户信息并去模型层与用户类表中的数据进行校对，
                // 如果正确则允许登录，并返回完整的用户信息，校对失败，则不允许登录，返回null对象
                user = userModel.Login(loginUser);

                if (null == user){
                    System.out.println("用户名或密码错误！");
                    System.exit(-1);
                }
                break;
            case 2:
                System.out.println("注册！");
                // 获取一个不完整的用户信息（不包括id和status）
                // 将获取的不完整的用户信息与用户信息集合中的信息进行校对，保证输入的用户是可用的（用户名不能重复）
                User regUser = UserPage.getRegUser();
                // 将这个用户对象通过模型层添加到用户信息集合中，并返回完整的用户信息
                // 将用户信息赋值给user，用于返回给主方法进行下一步操作
                user = userModel.Registered(regUser);
                break;
            case 0:
                UserPage.ByeBye();
                break;
        }
        return user;
    }


    /**
     * 用户权限控制 数据库版
     * @param user
     */
    public void AccessControl(User user) throws SQLException {
        if("2".equals(user.getStatus())){
            stuController.selectOperation(Stupage.selectFunctionSel());
        }else
            stuController.Operation(Stupage.stuWelcome());
    }
}
