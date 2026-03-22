<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="my.zhamri.csc584enterprise_programming.model.Student" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>

<h2>Student List</h2>

<a href="${pageContext.request.contextPath}/student/add">Add New Student</a>
<br><br>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Matric No</th>
        <th>Program</th>
        <th>Actions</th>
    </tr>

    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        if (students != null) {
            for (Student student : students) {
    %>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getMatricNo() %></td>
        <td><%= student.getProgram() %></td>
        <td>
            <a href="<%= request.getContextPath() %>/student/edit?id=<%= student.getId() %>">Edit</a>
            |
            <a href="<%= request.getContextPath() %>/student/delete?id=<%= student.getId() %>"
               onclick="return confirm('Are you sure to delete this student?');">Delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<br>
<a href="${pageContext.request.contextPath}/index.jsp">Back to Home</a>

</body>
</html>