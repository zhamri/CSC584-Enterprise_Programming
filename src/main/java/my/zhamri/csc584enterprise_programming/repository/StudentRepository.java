package my.zhamri.csc584enterprise_programming.repository;

import my.zhamri.csc584enterprise_programming.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final List<Student> students = new ArrayList<>();
    private static int nextId = 1;

    static {
        students.add(new Student(nextId++, "Ali", "A001", "Software Engineering"));
        students.add(new Student(nextId++, "Abu", "A002", "Information Technology"));
    }

    public static List<Student> findAll() {
        return students;
    }

    public static void add(Student student) {
        student.setId(nextId++);
        students.add(student);
    }

    public static Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public static void update(Student updatedStudent) {
        Student existing = findById(updatedStudent.getId());
        if (existing != null) {
            existing.setName(updatedStudent.getName());
            existing.setMatricNo(updatedStudent.getMatricNo());
            existing.setProgram(updatedStudent.getProgram());
        }
    }

    public static void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
