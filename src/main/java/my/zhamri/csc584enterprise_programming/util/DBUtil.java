package my.zhamri.csc584enterprise_programming.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String DB_URL = System.getProperty("APP_DB_URL");
    private static final String DB_USER = System.getProperty("APP_DB_USER");
    private static final String DB_PASSWORD = System.getProperty("APP_DB_PASSWORD");

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL JDBC Driver not found.", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (DB_URL == null || DB_URL.isBlank()) {
            throw new SQLException("APP_DB_URL is missing.");
        }
        if (DB_USER == null || DB_USER.isBlank()) {
            throw new SQLException("APP_DB_USER is missing.");
        }
        if (DB_PASSWORD == null || DB_PASSWORD.isBlank()) {
            throw new SQLException("APP_DB_PASSWORD is missing.");
        }

        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}