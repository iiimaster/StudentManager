package com.mryang.controller;

import com.mryang.globel.Student;
import com.mryang.model.StuModel;
import com.mryang.view.Stupage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName StuController.java
 * @Description TODO
 * @createTime 2021年05月06日 16:34:00
 */
public class StuController {

    private StuModel stuModel = new StuModel();

    /**
     * 学生功能控制器调度方法
     *
     * @param operation 用户将要进行的操作
     * @param stuList
     */
    public void Operation(int operation, ArrayList<Student> stuList) {
        switch (operation) {
            case 0:
                // 退出
                System.out.println("欢迎再次使用！~");
                System.exit(0);
            case 1:
                // 通过查询功能选择界面来选择通过哪种方式进行查询
                // 获取用户的查询功能请求之后,传递给查询功能调度方法
//                int selectOp = Stupage.selectFunctionSel();
                selectOperation(Stupage.selectFunctionSel(),stuList);
                break;
            case 2:
                // 添加
                System.out.println("tj");
                break;
            case 3:
                // 修改
                System.out.println("xg");
                break;
            case 4:
                // 删除
                System.out.println("sc");
                break;
        }
    }

    /**
     * 查询功能调度方法
     *
     * @param selectFunctionSel 用户输入的查询依据请求
     * @param stuList
     */
    private void selectOperation(int selectFunctionSel, ArrayList<Student> stuList) {
        // 查询结果集,初始化
        ArrayList<Student> res = null;

        switch (selectFunctionSel) {
            case 0: // 退出
                System.out.println("查询结束,已退出！");
                System.exit(0);
            case 1: // 查询全部
                System.out.println("全部学生学生信息查询如下:");
                res = stuModel.showAll(stuList);
                Stupage.showStuList(res);
                break;
            case 2: // 学号查询
                System.out.println("按照ID查询学生信息如下:");
                int id = Stupage.getStuID();
                res = stuModel.showById(stuList, id);
                Stupage.showStuList(res);
                break;
            case 3: // 姓名查询

                break;
            case 4: // 年龄查询

                break;
            case 5: // 成绩查询

                break;
        }
    }


}
