<%@ page import="java.util.*,my.zhamri.csc584enterprise_programming.model.Student" %>

<h2>Student List</h2>

<a href="student-form.jsp">Add New</a>

<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Matric</th><th>Program</th><th>Action</th>
    </tr>

    <%
        List<Student> list = (List<Student>) request.getAttribute("students");
        for(Student s : list){
    %>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getMatricNo() %></td>
        <td><%= s.getProgram() %></td>
        <td>
            <a href="delete?id=<%= s.getId() %>">Delete</a>
        </td>
    </tr>
    <% } %>
</table>