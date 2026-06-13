# CSC584-Enterprise_Programming
Build a simple login system using JSP, Servlet, JDBC, MySQL, and Session.

## Project Structure
```
JSPServletLogin
│
├── src
│   └── my/zhamri
│       ├── DBConnection.java
│       └── LoginServlet.java
│
├── webapp
│   ├── login.jsp
│   ├── welcome.jsp
│   ├── logout.jsp
│   └── WEB-INF
│       └── web.xml
│
└── mysql-connector-j.jar
```

## Database
```sql
CREATE DATABASE csc584db;

USE csc584db;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO users(username,password)
VALUES
('admin','1234'),
('ali','abcd');
```

## Display all data
```sql
mysql> select * from users;
+----+----------+----------+
| id | username | password |
+----+----------+----------+
|  1 | admin    | 1234     |
|  2 | ali      | abcd     |
+----+----------+----------+
2 rows in set (0.001 sec)
```



