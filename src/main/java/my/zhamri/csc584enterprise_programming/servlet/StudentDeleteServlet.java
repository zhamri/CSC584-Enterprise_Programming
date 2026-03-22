package my.zhamri.csc584enterprise_programming.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import my.zhamri.csc584enterprise_programming.repository.StudentRepository;

import java.io.IOException;

@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentRepository.delete(id);
        response.sendRedirect(request.getContextPath() + "/students");
    }
}
