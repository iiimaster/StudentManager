package com.mryang.jdbc;

import java.sql.*;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName JdbcDemo.java
 * @Description TODO Jdbc连接数据库
 * @createTime 2021年05月13日 21:25:00
 */
public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        System.getProperty("jdbc.driver","com.mysql.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver"); // 常用
        // 建立连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanager", "root", "toor");
        // 创建sql语句的执行对象
        Statement statement = conn.createStatement();
        // 组织并执行sql语句
        String sql = "select `id`,`stu_name`,`stu_age`,`stu_sex`,`stu_score`,`stu_tel`,`stu_classId` from `student`";
        ResultSet resultSet = statement.executeQuery(sql);
        // 处理结果集
        while(resultSet.next()){
            System.out.println(resultSet.getObject(1)+","
                    + resultSet.getObject(2)+","
                    + resultSet.getObject(3)+","
                    + resultSet.getObject(4)+","
                    + resultSet.getObject(5)+","
                    + resultSet.getObject(6)+","
                    + resultSet.getObject(7)
            );
        }
        // 关闭资源
        conn.close();
        resultSet.close();
        statement.close();
    }
}
