<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="my.zhamri.csc584enterprise_programming.model.Student" %>
<html>
<head>
  <title>Student Form</title>
</head>
<body>

<%
  String mode = (String) request.getAttribute("mode");
  Student student = (Student) request.getAttribute("student");

  boolean isEdit = "edit".equals(mode);

  String formAction = isEdit
          ? request.getContextPath() + "/student/edit"
          : request.getContextPath() + "/student/add";

  String name = isEdit && student != null ? student.getName() : "";
  String matricNo = isEdit && student != null ? student.getMatricNo() : "";
  String program = isEdit && student != null ? student.getProgram() : "";
%>

<h2><%= isEdit ? "Edit Student" : "Add Student" %></h2>

<form action="<%= formAction %>" method="post">
  <% if (isEdit && student != null) { %>
  <input type="hidden" name="id" value="<%= student.getId() %>">
  <% } %>

  Name: <input type="text" name="name" value="<%= name %>" required><br><br>
  Matric No: <input type="text" name="matricNo" value="<%= matricNo %>" required><br><br>
  Program: <input type="text" name="program" value="<%= program %>" required><br><br>

  <input type="submit" value="<%= isEdit ? "Update" : "Save" %>">
</form>

<br>
<a href="${pageContext.request.contextPath}/students">Back to List</a>

</body>
</html>