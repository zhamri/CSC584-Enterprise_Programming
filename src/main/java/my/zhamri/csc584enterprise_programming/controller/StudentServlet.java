package my.zhamri.csc584enterprise_programming.controller;

import my.zhamri.csc584enterprise_programming.dao.StudentDAO;
import my.zhamri.csc584enterprise_programming.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/*")
public class StudentServlet extends HttpServlet {

    private StudentDAO dao;

    @Override
    public void init() {
        dao = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String path = req.getServletPath();

        try {
            switch (path) {
                case "/insert":
                    dao.insert(new Student(
                            req.getParameter("name"),
                            req.getParameter("matricNo"),
                            req.getParameter("program")
                    ));
                    res.sendRedirect(req.getContextPath() + "/list");
                    break;

                case "/delete":
                    dao.delete(Integer.parseInt(req.getParameter("id")));
                    res.sendRedirect(req.getContextPath() + "/list");
                    break;

                case "/list":
                default:
                    req.setAttribute("students", dao.getAllStudents());
                    req.getRequestDispatcher("/views/student-list.jsp").forward(req, res);
                    break;
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}