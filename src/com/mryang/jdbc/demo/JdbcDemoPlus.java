package com.mryang.jdbc.demo;

import com.mryang.jdbc.JdbcUtils;
import java.sql.*;
import java.util.Scanner;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName JdbcDemoPlus.java
 * @Description TODO Jdbc防止sql注入
 * @createTime 2021年05月15日 14:47:00
 */
public class JdbcDemoPlus {
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static Connection connection = null;

    public static void main(String[] args) throws SQLException {
        System.out.print("mysql > ");
        String id = new Scanner(System.in).nextLine();
        readByID(id);
    }

    /**
     * 执行 查 操作
     * @param id 查询的sql语句
     */
    private static void readByID(String id) throws SQLException {
        // 获取连接
        connection = com.mryang.jdbc.JdbcUtils.getConnection();
        // 组织并执行sql
        String sql = "select * from `student` where id = ?";
        preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, Integer.parseInt(id));

        resultSet = preparedStatement.executeQuery();
        // 处理结果集
        while(resultSet.next()){
            System.out.printf("%-4d%-10s%-5d%-5d%-7d%-15d%-20s\n",
                    resultSet.getInt("id"),
                    resultSet.getString("stu_name"),
                    resultSet.getInt("stu_age"),
                    resultSet.getInt("stu_sex"),
                    resultSet.getInt("stu_score"),
                    resultSet.getInt("stu_tel"),
                    resultSet.getString("stu_classId")
            );
        }
        // 释放资源
        JdbcUtils.free(resultSet, preparedStatement, connection);
    }
}
