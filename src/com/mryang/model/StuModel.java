package com.mryang.model;

import com.mryang.globel.Student;

import java.util.ArrayList;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName StuModel.java
 * @Description TODO 学生模型层-输出处理
 * @createTime 2021年05月06日 20:59:00
 */
public class StuModel {

    /**
     * 获取全部的学生信息并返回集合
     *
     * @param stuList 学生数据集合
     * @return 全部学生的数据集合
     */
    public ArrayList<Student> showAll(ArrayList<Student> stuList) {
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
}
