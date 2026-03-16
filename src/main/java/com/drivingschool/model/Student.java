package com.drivingschool.model;

public class Student {

    private String studentId;
    private String name;
    private String email;
    private String phone;
    private String licenseType;
    private String enrollDate;

    public Student() {}

    public Student(String studentId, String name, String email,
                   String phone, String licenseType, String enrollDate) {
        this.studentId  = studentId;
        this.name       = name;
        this.email      = email;
        this.phone      = phone;
        this.licenseType = licenseType;
        this.enrollDate  = enrollDate;
    }

    // ── Getters ──────────────────────────────────────────────
    public String getStudentId()   { return studentId; }
    public String getName()        { return name; }
    public String getEmail()       { return email; }
    public String getPhone()       { return phone; }
    public String getLicenseType() { return licenseType; }
    public String getEnrollDate()  { return enrollDate; }

    // ── Setters ──────────────────────────────────────────────
    public void setStudentId(String studentId)     { this.studentId  = studentId; }
    public void setName(String name)               { this.name       = name; }
    public void setEmail(String email)             { this.email      = email; }
    public void setPhone(String phone)             { this.phone      = phone; }
    public void setLicenseType(String licenseType) { this.licenseType = licenseType; }
    public void setEnrollDate(String enrollDate)   { this.enrollDate  = enrollDate; }

    // ── File serialization (pipe-delimited) ──────────────────
    public String toFileString() {
        return studentId + "|" + name + "|" + email + "|" +
               phone + "|" + licenseType + "|" + enrollDate;
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length < 6) return null;
        return new Student(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
    }

    @Override
    public String toString() {
        return "Student{id=" + studentId + ", name=" + name + ", email=" + email + "}";
    }
}
