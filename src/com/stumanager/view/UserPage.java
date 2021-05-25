package com.stumanager.view;

import com.stumanager.globel.User;
import com.stumanager.model.UserModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName UserPage.java
 * @Description TODO 用户视图层 用户页面
 * @createTime 2021年05月10日 17:12:00
 */
public class UserPage {
    /**
     * 用户功能选择
     * @return 用户选择的功能
     */
    public static int userWelcome() {
        int operation = 0;
        System.out.println("* *********************** *");
        System.out.println("* 欢迎使用登录功能 *");
        System.out.println("* 1 - 登录 *");
        System.out.println("* 2 - 注册 *");
        System.out.println("* 0 - 退出 *");
        System.out.println("* ************************ *");

        do {
            System.out.print("请输入要进行的操作:");
            operation = new Scanner(System.in).nextInt();
        }while(operation > 2 || operation < 0);
        return operation;
    }

    /**
     * 操作成功反馈的信息
     * @param info 操作信息
     */
    public static void userActionSuccess(String info) {
        System.out.println("用户操作成功！" + info);
    }

    /**
     * 操作成功反馈的信息
     * @param info
     */
    public static void userActionFailed(String info) {
        System.out.println("操作失败！" + info);
    }

    /**
     * 获取登录信息
     * @return 用户不完整的信息（不包括用户ID和status）
     */
    public static User getLoginUser() {
        System.out.print("请输入用户名:");
        String userName = new Scanner(System.in).nextLine();
        System.out.print("请输入密码:");
        String password = new Scanner(System.in).nextLine();

        return new User(userName, password);
    }

    /**
     * 获取注册的用户信息（不包含id和status）
     * @param userList 用户信息集合
     * @return 不完整的用户信息
     */
    public static User getRegUser() throws SQLException {
        String userName = "";
        String password = "";

        while(true){ // 对用户名进行判断（存在则重新输入）
            System.out.print("请输入用户名:");
            userName = new Scanner(System.in).nextLine();
            // 模拟Ajax 做页面无刷新情况下的数据同步 也就是不通过Controller来做数据同步交互
            if (new UserModel().userNameExists(userName)){
                System.out.println("用户名已存在！请重新输入！");
            }else
                break;
        }
        while(true){
            System.out.print("请输入密码:");
            password = new Scanner(System.in).nextLine();
            System.out.print("请再次输入密码:");
            if(password.equals(new Scanner(System.in).nextLine())){
                break;
            }else{
                System.out.println("两次密码不一致！请重新输入！");
            }
        }
        return new User(userName,password);
    }

    /**
     * 退出页面
     */
    public static void ByeBye() {
        System.out.println("欢迎再次使用！ Bye！");
        System.exit(0);
    }

    public static void NumberOfAffected(int count) {
        System.out.println(count + "条数据受影响");
    }
}
