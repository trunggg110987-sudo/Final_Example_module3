package com.example.final_example_module3.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/tcomplex?useUnicode=true&characterEncoding=UTF-8&connectionCollation=utf8mb4_unicode_ci&serverTimezone=UTC";
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}