package com.drivingschool.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all file handlers.
 * Demonstrates ABSTRACTION and is the parent for INHERITANCE.
 */
public abstract class FileHandler {

    protected String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
        ensureFileExists();
    }

    // ── Abstract methods (overridden by each subclass = POLYMORPHISM) ──
    public abstract void save(Object obj) throws IOException;
    public abstract List<?> readAll() throws IOException;

    // ── Shared utility methods ────────────────────────────────────────

    /** Read every non-blank line from the file */
    protected List<String> readLines() throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return lines;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) lines.add(line.trim());
            }
        }
        return lines;
    }

    /** Append a single line to the file */
    protected void appendLine(String line) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(line);
            bw.newLine();
        }
    }

    /** Overwrite the entire file with new lines */
    protected void writeAllLines(List<String> lines) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, false))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
    }

    /** Delete a record by matching the first field (ID) */
    public void deleteById(String id) throws IOException {
        List<String> lines = readLines();
        List<String> updated = new ArrayList<>();
        for (String line : lines) {
            if (!line.startsWith(id + "|")) updated.add(line);
        }
        writeAllLines(updated);
    }

    /** Check if a record with the given ID already exists */
    public boolean existsById(String id) throws IOException {
        for (String line : readLines()) {
            if (line.startsWith(id + "|")) return true;
        }
        return false;
    }

    /** Create the file if it does not exist */
    private void ensureFileExists() {
        File file = new File(filePath);
        try {
            file.getParentFile().mkdirs();
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            System.err.println("Could not create file: " + filePath);
        }
    }
}
