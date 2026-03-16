package com.drivingschool.util;

import com.drivingschool.model.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Extends FileHandler – manages students.txt
 * Demonstrates INHERITANCE and POLYMORPHISM (overrides save + readAll).
 */
public class StudentFileHandler extends FileHandler {

    public StudentFileHandler() {
        super("data/students.txt");
    }

    /** Save (append) a new student record */
    @Override
    public void save(Object obj) throws IOException {
        Student student = (Student) obj;
        appendLine(student.toFileString());
    }

    /** Read all students from file */
    @Override
    public List<Student> readAll() throws IOException {
        List<Student> students = new ArrayList<>();
        for (String line : readLines()) {
            Student s = Student.fromFileString(line);
            if (s != null) students.add(s);
        }
        return students;
    }

    /** Find a single student by ID */
    public Student findById(String id) throws IOException {
        for (Student s : readAll()) {
            if (s.getStudentId().equals(id)) return s;
        }
        return null;
    }

    /** Update an existing student record */
    public void update(Student updated) throws IOException {
        List<String> lines = readLines();
        List<String> newLines = new ArrayList<>();
        for (String line : lines) {
            if (line.startsWith(updated.getStudentId() + "|")) {
                newLines.add(updated.toFileString());
            } else {
                newLines.add(line);
            }
        }
        writeAllLines(newLines);
    }
}
