package my.zhamri.csc584enterprise_programming;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/student.do")
public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String matricNo = request.getParameter("matricNo");
        String program = request.getParameter("program");

        // Create JavaBean
        Student student = new Student();
        student.setName(name);
        student.setMatricNo(matricNo);
        student.setProgram(program);

        // Send to JSP
        request.setAttribute("student", student);

        request.getRequestDispatcher("result.jsp")
                .forward(request, response);
    }
}
