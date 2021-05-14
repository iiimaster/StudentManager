package com.mryang.jdbc.demo;

import com.mryang.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName JdbcTest.java
 * @Description TODO 测试类
 * @createTime 2021年05月14日 21:50:00
 */
public class JdbcTest {
    public static void main(String[] args) throws SQLException {
        // 获取连接
        Connection connection = JdbcUtils.getConnection();
        // 获取sql执行对象
        Statement statement = connection.createStatement();
        // 组织并执行sql
        ResultSet resultSet = statement.executeQuery("select `id`,`stu_name`,`stu_age`,`stu_sex`,`stu_score`,`stu_tel`,`stu_classId` from `student`");
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
