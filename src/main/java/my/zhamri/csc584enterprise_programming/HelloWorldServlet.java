package my.zhamri.csc584enterprise_programming;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        response.getWriter().println("<h1>Hello World Servlet</h1>");
        response.getWriter().println(new Date());
    }
}