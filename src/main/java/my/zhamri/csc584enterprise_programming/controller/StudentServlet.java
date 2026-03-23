package my.zhamri.csc584enterprise_programming.controller;

import my.zhamri.csc584enterprise_programming.dao.StudentDAO;
import my.zhamri.csc584enterprise_programming.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/student/*")
public class StudentServlet extends HttpServlet {

    private StudentDAO studentDAO;

    @Override
    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String path = req.getPathInfo();

        try {
            if (path == null || "/list".equals(path)) {
                listStudents(req, res);
            } else if ("/new".equals(path)) {
                showNewForm(req, res);
            } else if ("/edit".equals(path)) {
                showEditForm(req, res);
            } else if ("/delete".equals(path)) {
                deleteStudent(req, res);
            } else {
                listStudents(req, res);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String path = req.getPathInfo();

        try {
            if ("/insert".equals(path)) {
                insertStudent(req, res);
            } else if ("/update".equals(path)) {
                updateStudent(req, res);
            } else {
                res.sendRedirect(req.getContextPath() + "/student/list");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listStudents(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ServletException, IOException {
        List<Student> students = studentDAO.getAllStudents();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/views/student-list.jsp").forward(req, res);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/student-form.jsp").forward(req, res);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentDAO.getStudentById(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("/views/student-form.jsp").forward(req, res);
    }

    private void insertStudent(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, IOException {
        String name = req.getParameter("name");
        String matricNo = req.getParameter("matricNo");
        String program = req.getParameter("program");

        Student student = new Student(name, matricNo, program);
        studentDAO.insertStudent(student);

        res.sendRedirect(req.getContextPath() + "/student/list");
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String matricNo = req.getParameter("matricNo");
        String program = req.getParameter("program");

        Student student = new Student(id, name, matricNo, program);
        studentDAO.updateStudent(student);

        res.sendRedirect(req.getContextPath() + "/student/list");
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentDAO.deleteStudent(id);

        res.sendRedirect(req.getContextPath() + "/student/list");
    }
}