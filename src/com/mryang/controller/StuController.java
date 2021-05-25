package com.mryang.controller;

import com.mryang.globel.Student;
import com.mryang.model.StuModel;
import com.mryang.view.Stupage;

import java.sql.SQLException;
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
    public void Operation(int operation, ArrayList<Student> stuList) throws SQLException {
        switch (operation) {
            case 0:
                // 退出
                System.out.println("欢迎再次使用！~");
                System.exit(0);
            case 1: // 查询
                // 通过查询功能选择界面来选择通过哪种方式进行查询
                // 获取用户的查询功能请求之后,传递给查询功能调度方法
//                int selectOp = Stupage.selectFunctionSel();
                selectOperation(Stupage.selectFunctionSel(),stuList);
                break;
            case 2: // 添加
                System.out.println("添加学生:");
                // 通过页面提示获取一个学生对象
                Student stu = Stupage.getStuObj();
                // 将学生对象传递给model层的学生的添加功能,并返回添加结果
                Boolean success = stuModel.addStu(stu,stuList);
                // 通过页面反馈给用户结果
                if(success) {
                    Stupage.stuActionSuccess("用户添加成功！");
                }else{
                    Stupage.stuActionFailed("用户添加失败！");
                }
                break;
            case 3: // 修改
                System.out.println("修改学生:");
                // 获取要修改的学生ID
                int editStuID = Stupage.getEditStuID();
                // 将获取到的学生信息放到修改页面
                Student editStu = stuModel.getEditStuByID(editStuID,stuList);
                // 在修改页面修改原始数据，并拿到修改后的学生对象
                if(null != editStu){
                    editStu = stuModel.EditStuInfo(editStu);
                }else{
                    Stupage.stuActionFailed("要修改的学员信息不存在！");
                    break;
                }
                // 在模型层对学生对象进行相应处理
                // 将要修改的学员ID和更新后的学生对象传递给模型层进行修改，并返回修改前的学员信息
                editStu = Stupage.updateStuByID(editStuID, editStu, stuList);
                // 返回操作结果
                Stupage.stuActionSuccess("修改成功！\n" + editStu);
                break;
            case 4: // 删除
                System.out.println("删除学生:");
                // 获取要删除学员ID
                int id = Stupage.getDelStuID();
                // 删除操作，并返回删除的学员信息
                Student delStu = stuModel.deleteStuByID(id,stuList);
                // 给予用户反馈
                if(delStu != null) {
                    Stupage.stuActionSuccess("删除成功！\n" + delStu);
                }else {
                    Stupage.stuActionFailed("删除失败！");
                }
                break;
        }
    }

    /**
     * 查询功能调度方法
     *
     * @param selectFunctionSel 用户输入的查询依据请求
     * @param stuList 用户信息集合
     */
    public void selectOperation(int selectFunctionSel, ArrayList<Student> stuList) throws SQLException {
        // 查询结果集,初始化
        ArrayList<Student> res = null;

        switch (selectFunctionSel) {
            case 0: // 退出
                System.out.println("查询结束,已退出！");
                System.exit(0);
            case 1: // 查询全部
                System.out.println("全部学生学生信息查询如下:");
                res = stuModel.showAll(stuList);
//                student = stuModel.showAll();
                Stupage.showStuList(res);
                break;
            case 2: // 学号查询
                System.out.println("按照ID查询学生信息如下:");
                int id = Stupage.getStuID();
                res = stuModel.showById(stuList, id);
                Stupage.showStuList(res);
                break;
            case 3: // 姓名查询
                System.out.println("按照姓名查询学生信息如下:");
                String name = Stupage.getStuName();
                res = stuModel.showByName(stuList, name);
                Stupage.showStuList(res);
                break;
            case 4: // 年龄查询
                System.out.println("按照年龄查询学生信息如下:");
                int age = Stupage.getStuAge();
                res = stuModel.showByAge(stuList, age);
                Stupage.showStuList(res);
                break;
            case 5: // 成绩查询
                System.out.println("按照成绩查询学生信息如下:");
                float score[] = Stupage.getStuScoreBetweenAnd();
                res = stuModel.showByScore(stuList, score);
                Stupage.showStuList(res);
                break;
        }
    }
}


