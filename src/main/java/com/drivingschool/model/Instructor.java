package com.drivingschool.model;

public class Instructor {

    private String instructorId;
    private String name;
    private String email;
    private String phone;
    private String licenseTypes;   // e.g. "A1,B,C"
    private boolean available;

    public Instructor() {}

    public Instructor(String instructorId, String name, String email,
                      String phone, String licenseTypes, boolean available) {
        this.instructorId  = instructorId;
        this.name          = name;
        this.email         = email;
        this.phone         = phone;
        this.licenseTypes  = licenseTypes;
        this.available     = available;
    }

    // ── Getters ──────────────────────────────────────────────
    public String  getInstructorId()  { return instructorId; }
    public String  getName()          { return name; }
    public String  getEmail()         { return email; }
    public String  getPhone()         { return phone; }
    public String  getLicenseTypes()  { return licenseTypes; }
    public boolean isAvailable()      { return available; }

    // ── Setters ──────────────────────────────────────────────
    public void setInstructorId(String instructorId)   { this.instructorId = instructorId; }
    public void setName(String name)                   { this.name         = name; }
    public void setEmail(String email)                 { this.email        = email; }
    public void setPhone(String phone)                 { this.phone        = phone; }
    public void setLicenseTypes(String licenseTypes)   { this.licenseTypes = licenseTypes; }
    public void setAvailable(boolean available)        { this.available    = available; }

    // ── File serialization ───────────────────────────────────
    public String toFileString() {
        return instructorId + "|" + name + "|" + email + "|" +
               phone + "|" + licenseTypes + "|" + available;
    }

    public static Instructor fromFileString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length < 6) return null;
        return new Instructor(parts[0], parts[1], parts[2],
                              parts[3], parts[4], Boolean.parseBoolean(parts[5]));
    }
}
