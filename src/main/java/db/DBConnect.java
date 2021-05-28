package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String DBDriver = "org.postgresql.Driver";
    private static final String DBUrl = "jdbc:postgresql://localhost:5432/BeautySalon?characterEncoding=utf8";
    private static final String DBUserName = "postgres";
    private static final String DBPassword = "admin";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DBDriver);
            connection = DriverManager.getConnection(DBUrl, DBUserName, DBPassword);
            System.out.println("Connection success");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }
}
