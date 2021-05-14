package com.mryang.jdbc;

import com.mryang.globel.User;

import java.sql.*;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName JdbcUtils.java
 * @Description TODO Dao封装成工具类
 * @createTime 2021年05月14日 21:13:00
 */
public class JdbcUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/studentmanager";
    private static final String USER = "root";
    private static final String PASSWORD = "toor";

    // 构造方法私有化，目的是为了防止类外对其进行实例化
    private JdbcUtils() {
    }

    // 注册驱动 - 在整个程序运行过程中仅被执行一次
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 释放资源
    public static void free(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (null != resultSet) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (null != statement) {
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if (null != connection){
                        connection.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }
}
