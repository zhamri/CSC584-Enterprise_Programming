package my.zhamri.csc584enterprise_programming.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import my.zhamri.csc584enterprise_programming.repository.StudentRepository;

import java.io.IOException;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("students", StudentRepository.findAll());
        request.getRequestDispatcher("/student-list.jsp").forward(request, response);
    }
}
