
# CSC584 Enterprise Programming

## Lab Exercise: JSP, Servlet, JDBC, MySQL and Session Login System

### Objective

The purpose of this lab is to develop a simple user login system using the following technologies:

* JSP (Java Server Pages)
* Servlet
* JDBC
* MySQL
* HTTP Session

At the end of this exercise, students should be able to:

1. Create a MySQL database and table.
2. Connect a Java web application to MySQL using JDBC.
3. Validate user login credentials using a Servlet.
4. Store user information in a Session.
5. Protect web pages from unauthorized access.
6. Implement user logout functionality.

---

## System Overview

The application consists of:

* `login.jsp` – Login page
* `LoginServlet.java` – Processes login requests
* `DBConnection.java` – Establishes database connection
* `welcome.jsp` – Protected page accessible only after successful login
* `logout.jsp` – Ends the session and logs the user out

### Application Flow

```text
User
 ↓
login.jsp
 ↓
LoginServlet
 ↓
MySQL Database
 ↓
Create Session
 ↓
welcome.jsp
 ↓
logout.jsp
```

---

## Project Structure

```text
JSPServletLogin
│
├── src/main/java
│   └── my/zhamri/csc584enterprise_programming
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
└── pom.xml
```

---

## Step 1: Create the Database

Open MySQL and execute the following SQL statements.

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

---

## Step 2: Verify the Database Records

Execute the following query:

```sql
SELECT * FROM users;
```

Expected output:

```text
+----+----------+----------+
| id | username | password |
+----+----------+----------+
|  1 | admin    | 1234     |
|  2 | ali      | abcd     |
+----+----------+----------+
```

---

## Step 3: Add MySQL Dependency

Open `pom.xml` and add the MySQL Connector dependency.

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.7.0</version>
</dependency>
```

After saving the file:

1. Reload Maven Project.
2. Ensure no dependency errors exist.

---

## Step 4: Create Database Connection Class

Create:

```text
src/main/java/my/zhamri/csc584enterprise_programming/DBConnection.java
```

Responsibilities:

* Load MySQL JDBC Driver.
* Establish connection to `csc584db`.
* Return a Connection object to the application.

---

## Step 5: Test Database Connectivity

Create:

```text
src/test/java/Check.java
```

The purpose of this class is to verify that:

* JDBC driver is loaded successfully.
* Database connection is established successfully.
* Data can be retrieved from MySQL.

Expected output:

```text
username: admin | password: 1234
username: ali | password: abcd
```

If this output is displayed, your database connection is working correctly.

---

## Step 6: Create Login Page

Create:

```text
src/main/webapp/login.jsp
```

This page should contain:

* Username textbox
* Password textbox
* Login button

The form should submit the data to:

```text
LoginServlet
```

using:

```html
method="post"
```

---

## Step 7: Create Login Servlet

Create:

```text
src/main/java/my/zhamri/csc584enterprise_programming/LoginServlet.java
```

Responsibilities:

1. Receive username and password from `login.jsp`.
2. Connect to MySQL.
3. Verify user credentials.
4. Create an HTTP Session if login is successful.
5. Redirect user to `welcome.jsp`.
6. Display an error message if login fails.

---

## Step 8: Create Protected Page

Create:

```text
src/main/webapp/welcome.jsp
```

Responsibilities:

1. Check whether a session exists.
2. Retrieve the username from the session.
3. Display a welcome message.

Example:

```text
Welcome admin
Login Successful
```

If no session exists:

```text
Redirect to login.jsp
```

This prevents unauthorized users from accessing the page directly.

---

## Step 9: Create Logout Page

Create:

```text
src/main/webapp/logout.jsp
```

Responsibilities:

1. Invalidate the current session.
2. Redirect the user back to `login.jsp`.

---

## Step 10: Configure web.xml

Create:

```text
src/main/webapp/WEB-INF/web.xml
```

Configure the welcome page:

```xml
<welcome-file-list>
    <welcome-file>login.jsp</welcome-file>
</welcome-file-list>
```

When the application starts, users will automatically be directed to:

```text
http://localhost:8080/csc584/login.jsp
```

---

## Step 11: Run the Application

Start Tomcat from IntelliJ IDEA.

Open:

```text
http://localhost:8080/csc584/login.jsp
```

---

## Step 12: Test Login

Use the following credentials:

```text
Username: admin
Password: 1234
```

Expected result:

```text
Welcome admin
Login Successful
```

---

## Step 13: Test Invalid Login

Use:

```text
Username: admin
Password: wrongpassword
```

Expected result:

```text
Invalid username or password. Please try again.
```

---

## Step 14: Test Session Protection

Without logging in, attempt to access:

```text
http://localhost:8080/csc584/welcome.jsp
```

Expected result:

```text
Redirect to login.jsp
```

This confirms that session protection is functioning correctly.

---

## Step 15: Test Logout

After logging in:

1. Click Logout.
2. Session should be destroyed.
3. User should be redirected to `login.jsp`.

Attempt to access:

```text
http://localhost:8080/csc584/welcome.jsp
```

Expected result:

```text
Redirect to login.jsp
```

