package com.stumanager.controller;

import com.stumanager.globel.Student;
import com.stumanager.model.StuModel;
import com.stumanager.view.Stupage;

import java.sql.SQLException;

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
     * 查询功能调度 数据库版
     * @param selectFunctionSel
     */
    public void selectOperation(int selectFunctionSel) throws SQLException {

        switch (selectFunctionSel) {
            case 0: // 退出
                System.out.println("查询结束,已退出！");
                System.exit(0);
            case 1: // 查询全部
                System.out.println("全部学生学生信息查询如下:");
                stuModel.showAll();
                break;
            case 2: // 学号查询
                System.out.println("按照ID查询学生信息如下:");
                int id = Stupage.getStuID();
                stuModel.showById(id);
                break;
            case 3: // 姓名查询
                System.out.println("按照姓名查询学生信息如下:");
                String name = Stupage.getStuName();
                stuModel.showByName(name);
                break;
            case 4: // 年龄查询
                System.out.println("按照年龄查询学生信息如下:");
                int age = Stupage.getStuAge();
                stuModel.showByAge(age);
                break;
            case 5: // 成绩查询
                System.out.println("按照成绩查询学生信息如下:");
                float score[] = Stupage.getStuScoreBetweenAnd();
                stuModel.showByScore(score);
                break;
        }

    }
    /**
     * 学生功能控制器调度方法 数据库版
     * @param stuWelcome
     */
    public void Operation(int stuWelcome) throws SQLException {
        switch (stuWelcome) {
            case 0:
                // 退出
                System.out.println("欢迎再次使用！~");
                System.exit(0);
            case 1: // 查询
                // 通过查询功能选择界面来选择通过哪种方式进行查询
                // 获取用户的查询功能请求之后,传递给查询功能调度方法
//                int selectOp = Stupage.selectFunctionSel();
                selectOperation(Stupage.selectFunctionSel());
                break;
            case 2: // 添加
                System.out.println("添加学生:");
                // 通过页面提示获取一个学生对象
                Student stu = Stupage.getStuObj();
                // 将学生对象传递给model层的学生的添加功能,并返回添加结果
                Boolean success = stuModel.addStu(stu);
                // 通过页面反馈给用户结果
                if(success) {
                    Stupage.stuActionSuccess("学生添加成功！");
                }else{
                    Stupage.stuActionFailed("学生添加失败！");
                }
                break;
            case 3: // 修改
                System.out.println("修改学生:");
                // 获取要修改的学生ID
                int editStuID = Stupage.getEditStuID();
                // 将获取到的学生信息放到修改页面
                Student editStu = stuModel.getEditStuByID(editStuID);
                // 在修改页面修改原始数据，并拿到修改后的学生对象
                if(null != editStu){
                    editStu = stuModel.EditStuInfo(editStu);
                }else{
                    Stupage.stuActionFailed("要修改的学员信息不存在！");
                    break;
                }
                // 在模型层对学生对象进行相应处理
                // 将要修改的学员ID和更新后的学生对象传递给模型层进行修改，并返回修改前的学员信息
                // 返回操作结果（true 成功）
                Boolean updateBln = StuModel.updateStuByID(editStuID, editStu);
                if (updateBln) {
                    Stupage.stuActionSuccess("修改成功！\n");
                }
                else {
                    Stupage.stuActionFailed("修改失败！\n");
                }
                break;
            case 4: // 删除
                System.out.println("删除学生:");
                // 获取要删除学员ID
                int id = Stupage.getDelStuID();
                // 判断学员是否存在
                Student deleStu = stuModel.getEditStuByID(id);
                if(null == deleStu) { // 学员不存在
                    Stupage.stuActionFailed("要删除的学员信息不存在！");
                    break;
                }
                // 删除操作，并返回删除的学员信息
                Boolean deleteBln = stuModel.deleteStuByID(id);
                // 给予用户反馈
                if(deleteBln) {
                    Stupage.stuActionSuccess("删除成功！\n");
                }else {
                    Stupage.stuActionFailed("删除失败！\n");
                }
                break;
        }
    }
}


