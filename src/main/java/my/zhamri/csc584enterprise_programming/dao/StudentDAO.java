package my.zhamri.csc584enterprise_programming.dao;

import my.zhamri.csc584enterprise_programming.model.Student;
import my.zhamri.csc584enterprise_programming.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, name, matric_no, program FROM student ORDER BY id";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("matric_no"),
                        rs.getString("program")
                ));
            }
        }

        return students;
    }

    public Student getStudentById(int id) throws SQLException {
        String sql = "SELECT id, name, matric_no, program FROM student WHERE id = ?";
        Student student = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("matric_no"),
                        rs.getString("program")
                );
            }
        }

        return student;
    }

    public void insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student (name, matric_no, program) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getMatricNo());
            ps.setString(3, student.getProgram());
            ps.executeUpdate();
        }
    }

    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE student SET name = ?, matric_no = ?, program = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getMatricNo());
            ps.setString(3, student.getProgram());
            ps.setInt(4, student.getId());
            ps.executeUpdate();
        }
    }

    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}