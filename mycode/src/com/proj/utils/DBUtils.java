package com.proj.utils;

import java.sql.*;

public class DBUtils {
    public String userName = "root";
    public String pwd = "x5";
    public String url = "jdbc:mysql://localhost:3306/pointdb1?useUnicode=true&characterEncoding=utf-8";
    public String Driver = "com.mysql.jdbc.Driver";


    public  Statement statement;
    public  ResultSet resultSet;
    public  Connection connection;


    public Connection getConnection (){
        try{
            Class.forName(Driver);
           connection = DriverManager.getConnection(url,userName,pwd);

        }catch (Exception e){
            e.printStackTrace();
        }
        return  connection;
    }

    public ResultSet doQuery(String sql){
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( sql );
            return resultSet;
        }catch (Exception e){
            e.printStackTrace();

        }

        return null;
    }

    public int doSave(String sql){
        connection = getConnection();
        try{
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            return  i ;

        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;

    }

    public void close(){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



}
