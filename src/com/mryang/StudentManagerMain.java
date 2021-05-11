package com.mryang;


import com.mryang.controller.StuController;
import com.mryang.controller.UserController;
import com.mryang.globel.MyUtils;
import com.mryang.globel.Student;
import com.mryang.globel.User;
import com.mryang.view.Stupage;
import com.mryang.view.UserPage;

import java.util.ArrayList;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName StudentManagerMain.java
 * @Description TODO 学生管理系统的主方法
 * @createTime 2021年05月06日 16:17:00
 */
public class StudentManagerMain {
    public static void main(String[] args) {
        // 定义一个用户控制器对象
        UserController uc = new UserController();
        // 定义一个学生控制器对象
        StuController sc = new StuController();

        ArrayList<User> userList = new ArrayList<>(); // 用户数据集合
        MyUtils.initUserList(userList); // 初始化用户信息
        ArrayList<Student> stuList = new ArrayList<>(); // 学员用户集合
        MyUtils.initStuList(stuList); // 初始化学员信息(测试数据)

        // 用户登录或注册的功能操作，如果操作失败则退出用户管理主程序
        int operation = UserPage.userWelcome();
        User user = uc.Operation(operation,userList);
        if (null != user)
            UserPage.userActionSuccess("欢迎用户 " + user.getUserName() +" 回来！");
        else{
            UserPage.userActionFailed("用户操作失败！");
            System.exit(-1); // 自定义退出码
        }

        // 学生管理的主程序
        // 调用视图层欢迎界面来让用户选择要进行的操作
        // 得到用户的请求之后传递给控制器进行功能的调度分配
//        int operation = Stupage.stuWelcome();
//         用户权限设置
//        if(user.equals("1")){
//            sc.
//        }
        while(true){
            sc.Operation(Stupage.stuWelcome(),stuList);
        }

    }

}
