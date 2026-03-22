package my.zhamri.csc584enterprise_programming.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import my.zhamri.csc584enterprise_programming.model.Student;
import my.zhamri.csc584enterprise_programming.repository.StudentRepository;

import java.io.IOException;

@WebServlet("/student/add")
public class StudentAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("mode", "add");
        request.getRequestDispatcher("/student-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String matricNo = request.getParameter("matricNo");
        String program = request.getParameter("program");

        Student student = new Student();
        student.setName(name);
        student.setMatricNo(matricNo);
        student.setProgram(program);

        StudentRepository.add(student);

        response.sendRedirect(request.getContextPath() + "/students");
    }
}
