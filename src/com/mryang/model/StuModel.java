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
     * @param stuList 学生数据集合
     * @return 全部学生的数据集合
     */
    public ArrayList<Student> showAll(ArrayList<Student> stuList) {
        return stuList;
    }

    /**
     * 获取对应ID的学生信息
     * @param stuList 学生数据集合
     * @param id 要查询的学生ID
     * @return 得到的学生数据集合
     */
    public ArrayList<Student> showById(ArrayList<Student> stuList, int id) {
        ArrayList<Student> res = new ArrayList<>();
        for (Student stu : stuList){
            if (id == stu.getId()) {
                res.add(stu);
            }
        }
        return res;
    }
}
