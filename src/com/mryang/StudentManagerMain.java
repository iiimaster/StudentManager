package com.mryang;


import com.mryang.controller.StuController;
import com.mryang.globel.MyUtils;
import com.mryang.globel.Student;
import com.mryang.view.Stupage;

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
        StuController sc = new StuController();

        ArrayList<Student> stuList = new ArrayList<>();
        MyUtils.initStuList(stuList); // 初始化学员信息(测试数据)

        // 调用视图层欢迎界面来让用户选择要进行的操作
        // 得到用户的请求之后传递给控制器进行功能的调度分配
//        int operation = Stupage.stuWelcome();
        sc.Operation(Stupage.stuWelcome(),stuList);

    }

}
