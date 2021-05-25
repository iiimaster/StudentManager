package com.stumanager.globel;

import java.util.ArrayList;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName MyUtils.java
 * @Description TODO 工具类
 * @createTime 2021年05月06日 16:21:00
 */
public class MyUtils {
    /**
     * 初始化学员信息
     * @param stuList 要添加的学员信息
     */
    public static void initStuList(ArrayList<Student> stuList) {
        stuList.add(new Student(1,"ZhangSan",1,13,99,"1234567890","yx2009"));
        stuList.add(new Student(2,"LiSi",0,14,77,"1234567890","yx2009"));
        stuList.add(new Student(3,"WangWu",0,15,34,"1234567890","yx2009"));
        stuList.add(new Student(4,"ZhaoLiu",1,16,78,"1234567890","yx2009"));
        stuList.add(new Student(5,"TianQi",1,17,99,"1234567890","yx2009"));
        stuList.add(new Student(6,"WangBa",1,18,87,"1234567890","yx2009"));
    }

    /**
     * 初始化用户信息
     * @param userList 用户信息集合
     */
    public static void initUserList(ArrayList<User> userList) {
        userList.add(new User(1,"root","toor","0"));
        userList.add(new User(1,"andy","ydna","1"));
    }
}
