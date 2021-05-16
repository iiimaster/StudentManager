package com.mryang.model;

import com.mryang.globel.Student;
import com.mryang.globel.User;
import com.mryang.jdbc.JdbcUtils;
import com.mryang.view.Stupage;
import com.mryang.view.UserPage;
import org.w3c.dom.stylesheets.StyleSheetList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName StuModel.java
 * @Description TODO 学生模型层-输出处理
 * @createTime 2021年05月06日 20:59:00
 */
public class StuModel {
    private ResultSet resultSet =  null;
    private PreparedStatement preparedStatement = null;
    private Connection connection = null;

    /**
     * 获取全部的学生信息并返回集合
     *
     * @param stuList 学生数据集合
     * @return 全部学生的数据集合
     */
    public ArrayList<Student> showAll(ArrayList<Student> stuList){
//        Student stu = null;
//        connection = JdbcUtils.getConnection();
//        String sql = "select `id`,`stu_name`,`stu_age`,`stu_sex`,`stu_score`,`stu_tel`,`stu_classid` from `student`";
//        preparedStatement = connection.prepareStatement(sql);
//        resultSet = preparedStatement.executeQuery();
//        JdbcUtils.free(resultSet,preparedStatement,connection);
//        Stupage.showStudent(resultSet);
        return stuList;
    }

    /**
     * 获取对应ID的学生信息
     *
     * @param stuList 学生数据集合
     * @param id      要查询的学生ID
     * @return 得到的学生数据集合
     */
    public ArrayList<Student> showById(ArrayList<Student> stuList, int id) {
        ArrayList<Student> res = new ArrayList<>();
        for (Student stu : stuList) {
            if (id == stu.getId()) {
                res.add(stu);
            }
        }
        return res;
    }

    /**
     * 根据姓名查询学生信息
     *
     * @param stuList 学生数据集合
     * @param name    学生姓名
     * @return 查询结果
     */
    public ArrayList<Student> showByName(ArrayList<Student> stuList, String name) {
        ArrayList<Student> res = new ArrayList<>();
        for (Student stu : stuList) {
            if (name.equals(stu.getName())) {
                res.add(stu);
            }
        }
        return res;
    }

    /**
     * 根据学生年龄查询
     *
     * @param stuList 学生数据集合
     * @param age     年龄
     * @return 查询结果
     */
    public ArrayList<Student> showByAge(ArrayList<Student> stuList, int age) {
        ArrayList<Student> res = new ArrayList<>();
        for (Student stu : stuList) {
            if (age == stu.getAge()) {
                res.add(stu);
            }
        }
        return res;
    }

    /**
     * 根据学生成绩区间查询
     * @param stuList 学生数据集合
     * @param score 成绩区间数组  [0] 最低分 [1] 最高分
     * @return 查询结果
     */
    public ArrayList<Student> showByScore(ArrayList<Student> stuList, float[] score) {
        ArrayList<Student> res = new ArrayList<>();
        for (Student stu : stuList) {
            if (stu.getScore() >= score[0] && stu.getScore() <= score[1]) {
                res.add(stu);
            }
        }
        return res;
    }

    /**
     * 像数据集合中添加一个学员
     * @param stu 要添加的学员信息
     * @param stuList 学员信息集合
     * @return 成功返回true
     */
    public Boolean addStu(Student stu, ArrayList<Student> stuList) {
        return stuList.add(stu);
    }

    /**
     * 根据ID删除学员
     * @param id 要删除的学员ID
     * @param stuList 学员信息集合
     * @return 成功则返回删除的学员，失败返回null
     */
    public Student deleteStuByID(int id, ArrayList<Student> stuList) {
        /*Student stu = null;
        Connection connection = JdbcUtils.getConnection();
        String sql = "delete from student where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        int count = preparedStatement.executeUpdate();
        UserPage.NumberOfAffected(count);
        return ;*/
        for (int i = 0; i < stuList.size(); i++) {
            if(id == stuList.get(i).getId()){

                return stuList.remove(i);
            }
        }
        return null;
    }

    /**
     * 根据ID查找学生信息
     * @param editStuID 要查找的学生信息
     * @param stuList 学生信息集合
     * @return 找到返回学生信息，没找到返回null
     */
    public Student getEditStuByID(int editStuID, ArrayList<Student> stuList) {
        for(Student stu : stuList) {
            if(editStuID == stu.getId()){
                return stu;
            }
        }
        return null;
    }

    /**
     * 修改学员信息
     * @param editStu 修改前的学员信息
     * @return 修改后的学员信息
     */
    public static Student EditStuInfo(Student editStu) {
        System.out.print("请输入学生学号(原:"+editStu.getId()+"):");
        int id = new Scanner(System.in).nextInt();
        System.out.print("请输入学生姓名(原:"+editStu.getName()+"):");
        String name = new Scanner(System.in).nextLine();
        System.out.print("请输入学生性别(原:"+editStu.getSex()+"):");
        String sex = new Scanner(System.in).nextLine();
        System.out.print("请输入学生年龄(原:"+editStu.getAge()+"):");
        int age = new Scanner(System.in).nextInt();
        System.out.print("请输入学生成绩(原:"+editStu.getScore()+"):");
        float score = new Scanner(System.in).nextFloat();

        return new Student(id,name,sex,age,score);
    }
}
