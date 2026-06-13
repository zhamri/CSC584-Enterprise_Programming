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
                    "jdbc:mysql://localhost:3306/csc584db", "root", ""
            );
            // Create statement
            Statement statement = connection.createStatement();
            // Execute query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            // Process results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password").trim();
                System.out.println("username: " + username + " | password: " + password);
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
