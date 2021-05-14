package com.mryang.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName JdbcOperate.java
 * @Description TODO java代码实现的 增 删 改 查（jdbc）
 * @createTime 2021年05月14日 22:39:00
 */
public class JdbcOperate {
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static Connection connection = null;

    public static void main(String[] args) throws SQLException {
        while(true) {
            System.out.println("please input a sql to execute : ");
            String sql = new Scanner(System.in).nextLine();
            // 操作
            ExecuteSql(sql);
        }
    }

    private static void ExecuteSql(String sql) throws SQLException {
        if (sql.startsWith("select"))
            read(sql);
        else if (sql.startsWith("update") || sql.startsWith("delete") || sql.startsWith("insert")) {
            cud(sql);
        }
    }

    /**
     * 执行 增-删-改的操作
     * @param sql 相关sql语句
     */
    private static void cud(String sql) throws SQLException {
        // 获取连接
        Connection connection = JdbcUtils.getConnection();
        // 获取sql执行对象
        Statement statement = connection.createStatement();

        int count = statement.executeUpdate(sql);

        System.out.println(count + "条语句受影响！");

        JdbcUtils.free(resultSet, statement, connection);
    }

    /**
     * 执行 查 操作
     * @param sql 查询的sql语句
     */
    private static void read(String sql) throws SQLException {
        // 获取连接
        Connection connection = JdbcUtils.getConnection();
        // 获取sql执行对象
        Statement statement = connection.createStatement();
        // 组织并执行sql
        ResultSet resultSet = statement.executeQuery(sql);
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
        JdbcUtils.free(resultSet, statement, connection);
    }
}
