package org.virtusa.zenstays.utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static final String URL = "jdbc:mysql://localhost:3306/zenstays";
    private static final String USER = "root";
    private static final String PASSWORD = "Praveen@pk";

    public static Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return con;
    }
}


