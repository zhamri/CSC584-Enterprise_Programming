package my.zhamri.csc584enterprise_programming.examplejava;

import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    // Database URL
    static final String URL = "jdbc:mysql://localhost:3306/sttpk2023db";

    // MySQL username
    static final String USER = "root";

    // MySQL password
    static final String PASSWORD = "";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT CRUD SYSTEM =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {

                case 1:
                    insertStudent(scan);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    updateStudent(scan);
                    break;

                case 4:
                    deleteStudent(scan);
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // CREATE
    public static void insertStudent(Scanner scan) {

        System.out.print("Enter name: ");
        String name = scan.nextLine();

        System.out.print("Enter email: ");
        String email = scan.nextLine();

        String sql = "INSERT INTO students(name, email) VALUES (?, ?)";

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, name);
            stmt.setString(2, email);

            int rows = stmt.executeUpdate();

            System.out.println(rows + " record inserted successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // READ
    public static void displayStudents() {

        String sql = "SELECT * FROM students";

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            System.out.println("\n===== STUDENT LIST =====");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println(id + " | " + name + " | " + email);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // UPDATE
    public static void updateStudent(Scanner scan) {

        System.out.print("Enter student ID to update: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter new name: ");
        String name = scan.nextLine();

        System.out.print("Enter new email: ");
        String email = scan.nextLine();

        String sql = "UPDATE students SET name=?, email=? WHERE id=?";

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);

            int rows = stmt.executeUpdate();

            System.out.println(rows + " record updated successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // DELETE
    public static void deleteStudent(Scanner scan) {

        System.out.print("Enter student ID to delete: ");
        int id = scan.nextInt();

        String sql = "DELETE FROM students WHERE id=?";

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            System.out.println(rows + " record deleted successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
