package com.stumanager.model;

import com.stumanager.globel.Student;
import com.stumanager.jdbc.JdbcUtils;
import com.stumanager.view.Stupage;
import com.stumanager.view.UserPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName StuModel.java
 * @Description TODO 学生模型层-输出处理
 * @createTime 2021年05月06日 20:59:00
 */
public class StuModel {
    private static ResultSet resultSet = null;
    private static PreparedStatement preparedStatement = null;
    private static Connection connection = null;

    /**
     * 查询全部学生
     *
     * @return
     */
    public void showAll() throws SQLException {
        connection = JdbcUtils.getConnection();
        String sql = "select `id`,`stu_name`,`stu_sex`,`stu_age`,`stu_score`,`stu_tel`,`stu_classid` from `student`";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        Stupage.showStu(resultSet); // 格式化显示信息

        JdbcUtils.free(resultSet, preparedStatement, connection);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public void showById(int id) throws SQLException {
        connection = JdbcUtils.getConnection();
        String sql = "select `id`,`stu_name`,`stu_sex`,`stu_age`,`stu_score`,`stu_tel`,`stu_classid` from `student` where id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();

        Stupage.showStu(resultSet); // 格式化显示信息

        JdbcUtils.free(resultSet, preparedStatement, connection);
    }

    /**
     * 根据姓名查询
     *
     * @param name
     * @return
     */
    public void showByName(String name) throws SQLException {
        connection = JdbcUtils.getConnection();
        String sql = "select `id`,`stu_name`,`stu_sex`,`stu_age`,`stu_score`,`stu_tel`,`stu_classid` from `student` where stu_name like ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        resultSet = preparedStatement.executeQuery();

        Stupage.showStu(resultSet); // 格式化显示信息

        JdbcUtils.free(resultSet, preparedStatement, connection);
    }

    /**
     * 根据年龄查询
     *
     * @param age
     * @return
     */
    public void showByAge(int age) throws SQLException {
        connection = JdbcUtils.getConnection();
        String sql = "select `id`,`stu_name`,`stu_sex`,`stu_age`,`stu_score`,`stu_tel`,`stu_classid` from `student` where stu_age = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, age);
        resultSet = preparedStatement.executeQuery();

        Stupage.showStu(resultSet); // 格式化显示信息

        JdbcUtils.free(resultSet, preparedStatement, connection);
    }

    /**
     * 根据成绩区间查询
     *
     * @param score
     * @return
     */
    public void showByScore(float[] score) throws SQLException {
        connection = JdbcUtils.getConnection();
        String sql = "select `id`,`stu_name`,`stu_sex`,`stu_age`,`stu_score`,`stu_tel`,`stu_classid` from `student` where stu_score >= ? and stu_score <= ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setFloat(1, score[0]);
        preparedStatement.setFloat(2, score[1]);
        resultSet = preparedStatement.executeQuery();

        Stupage.showStu(resultSet); // 格式化显示信息

        JdbcUtils.free(resultSet, preparedStatement, connection);
    }

    /**
     * 添加学生信息
     * @param stu 要添加的学生信息
     * @return 是否添加成功
     */
    public Boolean addStu(Student stu) throws SQLException {
        connection = JdbcUtils.getConnection();

        String sql = "insert into `student` values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,stu.getId());
        preparedStatement.setString(2, stu.getStu_name());
        preparedStatement.setInt(3, stu.getStu_sex());
        preparedStatement.setInt(4, stu.getStu_age());
        preparedStatement.setFloat(5, stu.getStu_score());
        preparedStatement.setString(6, stu.getStu_tel());
        preparedStatement.setString(7, stu.getClassid());

        int count = preparedStatement.executeUpdate();

        JdbcUtils.free(resultSet,preparedStatement,connection);

        if (count > 0){ // 操作成功
//            UserPage.NumberOfAffected(count);
            return true;
        }
        return false;
    }

    /**
     * 获取要修改的学员信息
     * @param editStuID
     * @return
     */
    public Student getEditStuByID(int editStuID) throws SQLException {
        Student stu = null;
        connection = JdbcUtils.getConnection();
        String sql = "select `id`,`stu_name`,`stu_sex`,`stu_age`,`stu_score`,`stu_tel`,`stu_classid` from `student` where id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, editStuID);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            stu =  new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("stu_name"),
                    resultSet.getInt("stu_sex"),
                    resultSet.getInt("stu_age"),
                    resultSet.getFloat("stu_score"),
                    resultSet.getString("stu_tel"),
                    resultSet.getString("stu_classid")
                    );
        }
        JdbcUtils.free(resultSet, preparedStatement, connection);
        return stu;
    }

    /**
     * 修改学员信息
     * @param editStu 修改前的学员信息
     * @return 修改后的学员信息
     */
    public Student EditStuInfo(Student editStu) {
        System.out.print("请输入学生学号(原:" + editStu.getId() + "):");
        int id = new Scanner(System.in).nextInt();
        System.out.print("请输入学生姓名(原:" + editStu.getStu_name() + "):");
        String name = new Scanner(System.in).nextLine();
        System.out.print("请输入学生性别(原:" + editStu.getStu_sex() + "):");
        int sex = new Scanner(System.in).nextInt();
        System.out.print("请输入学生年龄(原:" + editStu.getStu_age() + "):");
        int age = new Scanner(System.in).nextInt();
        System.out.print("请输入学生成绩(原:" + editStu.getStu_score() + "):");
        float score = new Scanner(System.in).nextFloat();
        System.out.print("请输入学生电话(原:" + editStu.getStu_tel() + "):");
        String tel = new Scanner(System.in).nextLine();
        System.out.print("请输入学生班级(原:" + editStu.getClassid() + "):");
        String classid = new Scanner(System.in).nextLine();

        return new Student(id, name, age, sex, score, tel, classid);
    }

    /**
     * 修改学员信息
     * @param editStuID
     * @param editStu
     */
    public static Boolean updateStuByID(int editStuID, Student editStu) throws SQLException {
        connection = JdbcUtils.getConnection();
        String sql = "update `student` set `id`=?,`stu_name`=?,`stu_sex`=?,`stu_age`=?,`stu_score`=?,`stu_tel`=?,`stu_classid`=? where `id` = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,editStu.getId());
        preparedStatement.setString(2,editStu.getStu_name());
        preparedStatement.setInt(3,editStu.getStu_sex());
        preparedStatement.setInt(4,editStu.getStu_age());
        preparedStatement.setFloat(5, editStu.getStu_score());
        preparedStatement.setString(6,editStu.getStu_tel());
        preparedStatement.setString(7,editStu.getClassid());
        preparedStatement.setInt(8,editStuID);
        int count = preparedStatement.executeUpdate();
        JdbcUtils.free(resultSet,preparedStatement,connection);
        if (count > 0) {
            return true;
        }else
            return false;
    }


    /**
     * 根据ID删除学员
     *
     * @param id      要删除的学员ID
     * @return 成功则返回删除的学员，失败返回null
     */
    public Boolean deleteStuByID(int id) throws SQLException {
        Student stu = null;

        Connection connection = JdbcUtils.getConnection();
        String sql = "delete from student where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        int count = preparedStatement.executeUpdate();
        UserPage.NumberOfAffected(count);
        JdbcUtils.free(resultSet,preparedStatement,connection);
        if (count > 0){ // 操作成功
            return true;
        }
        return false;
    }

}
