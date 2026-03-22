package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import my.zhamri.csc584enterprise_programming.Student;

import java.io.IOException;

@WebServlet("/student.do")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student student = new Student();
        student.setName("Zhamri");
        student.setMatricNo("20260001");
        student.setProgram("Enterprise Programming");

        request.setAttribute("student", student);
        request.getRequestDispatcher("/student.jsp").forward(request, response);
    }
}