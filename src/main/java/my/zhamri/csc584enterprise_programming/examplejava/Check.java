package my.zhamri.csc584enterprise_programming.examplejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Check {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sttpk2023db", "root", ""
            );
            // Create statement
            Statement statement = connection.createStatement();
            // Execute query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            // Process results
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email").trim();
                System.out.println("Name: " + name + " | Email: " + email);
            }
            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
