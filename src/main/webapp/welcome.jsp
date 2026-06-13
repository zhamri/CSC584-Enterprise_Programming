<%
  String username =
          (String) session.getAttribute("username");

  if(username == null){

    response.sendRedirect("login.jsp");

    return;
  }
%>

<!DOCTYPE html>
<html>
<head>
  <title>Welcome</title>
</head>
<body>

<h2>Welcome <%= username %></h2>

<p>Login Successful</p>

<a href="logout.jsp">
  Logout
</a>

</body>
</html>