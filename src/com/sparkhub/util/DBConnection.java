package com.sparkhub.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sparkhub",
                "root",
                "spark123"
            );
        } catch (Exception e) {
            return null; // silent
        }
    }
}