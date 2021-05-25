package com.stumanager.model;

import com.stumanager.globel.User;
import com.stumanager.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName UserModel.java
 * @Description TODO 用户模型层
 * @createTime 2021年05月10日 17:11:00
 */
public class UserModel {
    private static int userRegID = 3;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    /**
     * 对用户信息进行校对
     * @param loginUser 拿到的不完整的用户信息（包含必要信息）
     * @param userList 用户信息集合
     * @return  校对成功 完整的用户信息，失败 null
     */
    public User Login(User loginUser) throws SQLException {
        User user = null;
        Connection connection = JdbcUtils.getConnection();
        String sql = "select `id`,`username`,`password`,`status` from `user` where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,loginUser.getUserName());
        preparedStatement.setString(2,loginUser.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            user = new User(resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("status"));
        }
        JdbcUtils.free(resultSet,preparedStatement,connection);
        return user;
       /* 非Jdbc版
       System.out.println(loginUser);
        for (User user : userList){
            if(loginUser.getUserName().equals(user.getUserName())){ // 用户名校对成功
                if (loginUser.getPassword().equals(user.getPassword())){ // 密码校对成功
                    return user;
                }
            }
        }
        return null;*/
    }

    /**
     * 判断用户名是否存在
     * @param userName 要判断的用户名
     * @param userList 用户信息集合
     * @return true 存在，false 不存在
     */
    public boolean userNameExists(String userName) throws SQLException {
        connection = JdbcUtils.getConnection();
        String sql = "select `id`,`username`,`password`,`status` from `user` where username = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,userName);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
            return true;
        return false;
    }

    /**
     * 获取完整用户信息
     * @param regUser 不完整的用户信息
     * @param userList 用户信息集合
     * @return 完整用户信息
     */
    public User Registered(User regUser) throws SQLException {
        connection = JdbcUtils.getConnection();
        String sql = "insert into user (`username`,`password`) values (?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,regUser.getUserName());
        preparedStatement.setString(2,regUser.getPassword());
        int count = preparedStatement.executeUpdate();
        JdbcUtils.free(resultSet,preparedStatement,connection);
        if(count > 0)
            return selByUsername(regUser.getUserName());
        return null;
        /*regUser.setId(userRegID++);
        regUser.setStatus("2"); // 0 超级管理员 1 管理员 2 普通用户（注册只能是普通用户）
        // 将用户完整信息添加到用户信息集合中
        userList.add(regUser);
        // 查询已注册的用户(测试)
//        System.out.println(userList);
        return regUser;*/
    }

    /**
     * 获取用户名查询用户信息
     * @param userName  用户名
     * @return 完整用户信息 失败返回null
     */
    private User selByUsername(String userName) throws SQLException {
        User user = null;
        connection = JdbcUtils.getConnection();
        String sql = "select `id`,`username`,`password`,`status` from `user` where username = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,userName);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            user =  new User(resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("status"));
        }
        JdbcUtils.free(resultSet,preparedStatement,connection);
        return user;
    }
}
