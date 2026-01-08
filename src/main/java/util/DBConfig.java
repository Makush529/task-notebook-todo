package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private static final String URL =  "jdbc:postgresql://localhost:5432/database_first";
    private static final String LOGIN = "user529";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL,LOGIN,PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            throw new RuntimeException(e);
        }
    }
}
