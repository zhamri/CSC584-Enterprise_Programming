<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
</head>
<body>

<h2>Login System</h2>

<form action="LoginServlet" method="post">

  Username:
  <input type="text"
         name="username"
         required>

  <br><br>

  Password:
  <input type="password"
         name="password"
         required>

  <br><br>

  <input type="submit"
         value="Login">

</form>

<%
  String error = request.getParameter("error");

  if(error != null){
%>

<p style="color:red;">
  Invalid username or password. Please try again.
</p>

<%
  }
%>

</body>
</html>