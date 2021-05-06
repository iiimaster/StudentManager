package com.mryang.view;

import com.mryang.globel.Student;

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
     * 显示全部学员信息
     * @param stuList 要显示的学员信息集合
     */
    public static void showStuList(ArrayList<Student> stuList) {
        String[] sex = {"girl", "boy"};
        System.out.printf("┌────┬────────────┬─────┬────┬────────┐\n");
        System.out.printf("│%-4s│%-12s│%-5s│%-4s│%-8s│\n",
                "id","name","sex","age","score");
        for (Student stu : stuList){
            System.out.printf("├────┼────────────┼─────┼────┼────────┤\n");
            System.out.printf("│%-4d│%-12s│%-5s│%-4d│%-8.2f│\n",
                    stu.getId(),stu.getName(),sex[Integer.parseInt(stu.getSex())],stu.getAge(),stu.getScore());
        }
        System.out.printf("└────┴────────────┴─────┴────┴────────┘\n");
    }

    /**
     * 学生管理欢迎界面，选择功能
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
        }while(num > 4 || num < 0);
        return num;
    }

    /**
     * 查询功能选择界面
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
        }while(num > 5 || num < 0);
        return num;
    }

    /**
     * 获取要查询的学生学号
     * @return 学生学号
     */
    public static int getStuID() {
        System.out.print("请输入要查询的学号:");
        return new Scanner(System.in).nextInt();
    }
}
