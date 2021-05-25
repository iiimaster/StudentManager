package com.stumanager.view;

import com.stumanager.globel.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName Stupage.java
 * @Description TODO
 * @createTime 2021年05月06日 16:20:00
 */
public class Stupage {

    /**
     * 格式化显示查询结果
     * @param resultSet
     */
    public static void showStu(ResultSet resultSet) throws SQLException {
        String[] sex = {"girl", "boy"};
        System.out.printf("┌────┬────────────┬─────┬────┬────────┬────────────┬────────────┐\n");
        System.out.printf("│%-4s│%-12s│%-5s│%-4s│%-8s│%-12s│%-12s│\n",
                "id", "name", "sex", "age", "score","tel","classid");
        while (resultSet.next()) {
            System.out.printf("├────┼────────────┼─────┼────┼────────┼────────────┼────────────┤\n");
            System.out.printf("│%-4d│%-12s│%-5d│%-4d│%-8.2f│%-12s│%-12s│\n",
                    resultSet.getInt("id"),
                    resultSet.getString("stu_name"),
                    resultSet.getInt("stu_sex"),
                    resultSet.getInt("stu_age"),
                    resultSet.getFloat("stu_score"),
                    resultSet.getString("stu_tel"),
                    resultSet.getString("stu_classid"));
        }
        System.out.printf("└────┴────────────┴─────┴────┴────────┴────────────┴────────────┘\n");
    }

    /**
     * 学生管理欢迎界面，选择功能
     *
     * @return 用户选择的功能
     */
    public static int stuWelcome() {
        System.out.println("* ******************** *");
        System.out.println("* 欢迎使用学生管理系统 *");
        System.out.println("* 1 - 查询学员");
        System.out.println("* 2 - 添加学员");
        System.out.println("* 3 - 修改学员");
        System.out.println("* 4 - 删除学员");
        System.out.println("* 0 - 退出系统");
        System.out.println("* ******************** *");
        int num;
        do {
            System.out.print("请选择您要进行的操作:");
            num = new Scanner(System.in).nextInt();
        } while (num > 4 || num < 0);
        return num;
    }

    /**
     * 查询功能选择界面
     *
     * @return 用户选择功能
     */
    public static int selectFunctionSel() {
        System.out.println("* ******************** *");
        System.out.println("* 请选择查询依据 *");
        System.out.println("* 1 - 查询全部");
        System.out.println("* 2 - 学号全部");
        System.out.println("* 3 - 姓名查询");
        System.out.println("* 4 - 年龄查询");
        System.out.println("* 5 - 成绩查询");
        System.out.println("* 0 - 退出查询");
        System.out.println("* ******************** *");
        int num;
        do {
            System.out.print("请选择您要进行的操作:");
            num = new Scanner(System.in).nextInt();
        } while (num > 5 || num < 0);
        return num;
    }

    /**
     * 获取要查询的学生学号
     *
     * @return 学生学号
     */
    public static int getStuID() {
        System.out.print("请输入要查询的学号:");
        return new Scanner(System.in).nextInt();
    }

    /**
     * 获取要查询的学生姓名
     *
     * @return 姓名
     */
    public static String getStuName() {
        System.out.print("请输入要查询的学生姓名:");
        return new Scanner(System.in).nextLine();
    }

    /**
     * 获取要查询的学生年龄
     *
     * @return 年龄
     */
    public static int getStuAge() {
        System.out.print("请输入要查询的学生年龄:");
        return new Scanner(System.in).nextInt();
    }

    /**
     * 获取要查询的成绩区间
     *
     * @return 成绩 [0] 最低分 [1] 最高分
     */
    public static float[] getStuScoreBetweenAnd() {
        float[] score = new float[2];
        System.out.print("请输入要查询的最低分:");
        score[0] = new Scanner(System.in).nextInt();
        System.out.print("请输入要查询的最高分:");
        score[1] = new Scanner(System.in).nextInt();
        return score;
    }

    /**
     * 添加学生信息
     *
     * @return 学生信息
     */
    public static Student getStuObj() {
        System.out.print("请输入学生学号:");
        int id = new Scanner(System.in).nextInt();
        System.out.print("请输入学生姓名:");
        String name = new Scanner(System.in).nextLine();
        System.out.print("请输入学生性别:");
        int sex = new Scanner(System.in).nextInt();
        System.out.print("请输入学生年龄:");
        int age = new Scanner(System.in).nextInt();
        System.out.print("请输入学生成绩:");
        float score = new Scanner(System.in).nextFloat();
        System.out.print("请输入学生电话:");
        String tel = new Scanner(System.in).nextLine();
        System.out.print("请输入学生班级:");
        String classid = new Scanner(System.in).nextLine();

        return new Student(id,name, age, sex, score, tel, classid);
    }

    /**
     * 学生相关操作成功提示页面
     *
     * @param info 具体操作提示信息
     */
    public static void stuActionSuccess(String info) {
        System.out.println("学生相关操作成功！ -- " + info);
    }

    /**
     * 学生相关操作失败提示页面
     *
     * @param info
     */
    public static void stuActionFailed(String info) {
        System.out.println("学生相关操作失败！ -- " + info);
    }

    /**
     * 获取要删除的学员ID
     *
     * @return 要删除的学员ID
     */
    public static int getDelStuID() {
        System.out.print("请输入要删除的学员ID:");
        return new Scanner(System.in).nextInt();
    }

    /**
     * 获取要修改的学员ID
     *
     * @return 要修改的学员ID
     */
    public static int getEditStuID() {
        System.out.print("请输入要修改的学员ID:");
        return new Scanner(System.in).nextInt();
    }


    /**
     * 根据ID修改学员信息
     *
     * @param editStuID 修改的学员ID
     * @param editStu   修改后的学员信息
     * @param stuList   学员信息集合
     * @return 修改前的学员信息, 失败返回null
     */
    public static com.mryang.globel.Student updateStuByID(int editStuID, com.mryang.globel.Student editStu, ArrayList<com.mryang.globel.Student> stuList) {
        for (int i = 0; i < stuList.size(); i++) {
            if(editStuID == stuList.get(i).getId()){
                return stuList.set(i, editStu);
            }
        }
        return null;
    }

}
