package com.example.demo_crud.DatabaseAccess;

import java.sql.*;

public class DataAccess {
    public static   Connection AccessDB() throws ClassNotFoundException, SQLException {
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/";
        String dbName = "demo";
        String dbUsername = "root";
        String dbPassword = "abc1234";

        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
    }
//    public static void main(String args[]) throws SQLException, ClassNotFoundException {
//        Connection con = AccessDB();
//        String name = "abcd";
//        String email = "abc@gmail.com";
//        String password = BCrypt.hashpw("123456",BCrypt.gensalt(10));
//        PreparedStatement preparedStatement = con.prepareStatement(" INSERT into user (email, password, name) " + "values ( ?, ?, ?)");
//        preparedStatement.setObject(1,email);
//        preparedStatement.setObject(2,password);
//        preparedStatement.setObject(3,name);
//        preparedStatement.execute();
////        Statement statement = con.createStatement();
////        statement.execute(" INSERT into user (email, password, name) " + "values ( email, password, name)");
//        System.out.println(password);
//        if (BCrypt.checkpw("123456",password)) System.out.println("True");
//        else System.out.println("false");
//    }
}
