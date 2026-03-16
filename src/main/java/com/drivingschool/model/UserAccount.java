package com.drivingschool.model;

public class UserAccount {

    private String userId;
    private String username;
    private String passwordHash;
    private String role;   // Admin / Student / Instructor

    public UserAccount() {}

    public UserAccount(String userId, String username, String passwordHash, String role) {
        this.userId       = userId;
        this.username     = username;
        this.passwordHash = passwordHash;
        this.role         = role;
    }

    // ── Getters ──────────────────────────────────────────────
    public String getUserId()       { return userId; }
    public String getUsername()     { return username; }
    public String getPasswordHash() { return passwordHash; }
    public String getRole()         { return role; }

    // ── Setters ──────────────────────────────────────────────
    public void setUserId(String userId)             { this.userId       = userId; }
    public void setUsername(String username)         { this.username     = username; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setRole(String role)                 { this.role         = role; }

    // ── File serialization ───────────────────────────────────
    public String toFileString() {
        return userId + "|" + username + "|" + passwordHash + "|" + role;
    }

    public static UserAccount fromFileString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length < 4) return null;
        return new UserAccount(parts[0], parts[1], parts[2], parts[3]);
    }
}
