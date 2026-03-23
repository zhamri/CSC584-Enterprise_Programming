package my.zhamri.csc584enterprise_programming.dao;

import my.zhamri.csc584enterprise_programming.model.Student;
import my.zhamri.csc584enterprise_programming.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM student";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("matric_no"),
                        rs.getString("program")
                ));
            }
        }

        return list;
    }

    public void insert(Student s) throws Exception {
        String sql = "INSERT INTO student(name, matric_no, program) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getMatricNo());
            ps.setString(3, s.getProgram());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws Exception {
        String sql = "DELETE FROM student WHERE id=?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
