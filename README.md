# CSC584-Enterprise_Programming

## Project Structure
```
supabase-student-crud/
│
├── .env                     ❌ (NOT shared with others)
├── .gitignore
├── pom.xml
│
├── src/
│   └── main/
│
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │
│       │           ├── model/
│       │           │   └── Student.java
│       │
│       │           ├── dao/
│       │           │   └── StudentDAO.java
│       │
│       │           ├── controller/
│       │           │   └── StudentServlet.java
│       │
│       │           └── util/
│       │               └── DBUtil.java
│
│       ├── resources/
│       │   └── (optional config files)
│
│       └── webapp/
│           ├── index.jsp
│           │
│           ├── views/
│           │   ├── student-list.jsp
│           │   └── student-form.jsp
│           │
│           └── WEB-INF/
│               └── web.xml   (optional)
│
└── target/
```