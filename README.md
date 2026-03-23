## Project Structure
```
CSC584-Enterprise_Programming/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── my/
│       │       └── zhamri/
│       │           └── csc584enterprise_programming/
│       │               ├── controller/
│       │               │   └── StudentServlet.java
│       │               ├── dao/
│       │               │   └── StudentDAO.java
│       │               ├── model/
│       │               │   └── Student.java
│       │               └── util/
│       │                   └── DBUtil.java
│       └── webapp/
│           ├── index.jsp
│           └── views/
│               ├── student-form.jsp
│               └── student-list.jsp
```

## SQL table
```sql
CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    matric_no VARCHAR(50) NOT NULL,
    program VARCHAR(100) NOT NULL
);
```