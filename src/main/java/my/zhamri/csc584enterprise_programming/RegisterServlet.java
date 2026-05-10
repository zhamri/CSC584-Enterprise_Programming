package my.zhamri.csc584enterprise_programming;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String program = request.getParameter("program");

        // Create session
        HttpSession session = request.getSession();

        // Store username in session
        session.setAttribute("username", name);

        // Set content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Display output
        out.println("<html><body>");

        out.println("<h1>Registration Successful!</h1>");

        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Program: " + program + "</p>");

        // Welcome message using session
        out.println("<h2>Welcome, "
                + session.getAttribute("username")
                + "!</h2>");

        out.println("</body></html>");
    }
}