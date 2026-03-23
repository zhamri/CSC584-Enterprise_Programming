<%@ page import="my.zhamri.csc584enterprise_programming.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Student student = (Student) request.getAttribute("student");
    boolean editMode = (student != null);
%>

<html>
<head>
    <title><%= editMode ? "Edit Student" : "Add Student" %>
    </title>
</head>
<body>
<h2><%= editMode ? "Edit Student" : "Add New Student" %>
</h2>

<form action="<%= request.getContextPath() %>/student/<%= editMode ? "update" : "insert" %>" method="post">
    <% if (editMode) { %>
    <input type="hidden" name="id" value="<%= student.getId() %>">
    <% } %>

    <table>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name"
                       value="<%= editMode ? student.getName() : "" %>" required>
            </td>
        </tr>
        <tr>
            <td>Matric No:</td>
            <td>
                <input type="text" name="matricNo"
                       value="<%= editMode ? student.getMatricNo() : "" %>" required>
            </td>
        </tr>
        <tr>
            <td>Program:</td>
            <td>
                <input type="text" name="program"
                       value="<%= editMode ? student.getProgram() : "" %>" required>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Save</button>
                <a href="<%= request.getContextPath() %>/student/list">Back</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>