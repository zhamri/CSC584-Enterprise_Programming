package my.zhamri.csc584enterprise_programming;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/")
public class ConnectionTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        String url = System.getProperty("APP_DB_URL");
        String user = System.getProperty("APP_DB_USER");
        String password = System.getProperty("APP_DB_PASSWORD");

        out.println("<html><body>");
        out.println("<h2>Environment Variable Test</h2>");

        out.println("<ul>");
        out.println("<li>APP_DB_URL: " + (url != null ? "FOUND" : "NULL") + "</li>");
        out.println("<li>APP_DB_USER: " + (user != null ? "FOUND" : "NULL") + "</li>");
        out.println("<li>APP_DB_PASSWORD: " + (password != null ? "FOUND" : "NULL") + "</li>");
        out.println("</ul>");

        // Try DB connection
        out.println("<h2>Database Test</h2>");

        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            out.println("<p>Connected to database</p>");

            out.println("<table border='1' cellpadding='8'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Matric No</th><th>Program</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("matric_no") + "</td>");
                out.println("<td>" + rs.getString("program") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<p style='color:red;'>DB Error: " + e.getMessage() + "</p>");
            e.printStackTrace();
        }

        out.println("</body></html>");
    }
}