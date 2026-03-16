package com.drivingschool.util;

import com.drivingschool.model.Instructor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Extends FileHandler – manages instructors.txt
 */
public class InstructorFileHandler extends FileHandler {

    public InstructorFileHandler() {
        super("data/instructors.txt");
    }

    @Override
    public void save(Object obj) throws IOException {
        Instructor instructor = (Instructor) obj;
        appendLine(instructor.toFileString());
    }

    @Override
    public List<Instructor> readAll() throws IOException {
        List<Instructor> list = new ArrayList<>();
        for (String line : readLines()) {
            Instructor i = Instructor.fromFileString(line);
            if (i != null) list.add(i);
        }
        return list;
    }

    public Instructor findById(String id) throws IOException {
        for (Instructor i : readAll()) {
            if (i.getInstructorId().equals(id)) return i;
        }
        return null;
    }

    public void update(Instructor updated) throws IOException {
        List<String> lines = readLines();
        List<String> newLines = new ArrayList<>();
        for (String line : lines) {
            if (line.startsWith(updated.getInstructorId() + "|")) {
                newLines.add(updated.toFileString());
            } else {
                newLines.add(line);
            }
        }
        writeAllLines(newLines);
    }
}
