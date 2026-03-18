package com.drivingschool.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection utility – Aiven Cloud MySQL
 */
public class DBConnection {

    private static final String HOST     = "drivingchooldb-my-4536.a.aivencloud.com";
    private static final String PORT     = "16760";
    private static final String DATABASE = "driving_school_db";
    private static final String USER     = "avnadmin";
    private static final String PASSWORD = "AVNS_rOC9kStdSBH-EqIfTpr";

    private static final String URL =
            "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE +
                    "?useSSL=true" +
                    "&requireSSL=true" +
                    "&sslMode=REQUIRED" +
                    "&verifyServerCertificate=false" +
                    "&allowPublicKeyRetrieval=true" +
                    "&serverTimezone=UTC" +
                    "&useUnicode=true" +
                    "&characterEncoding=UTF-8";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found!", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
