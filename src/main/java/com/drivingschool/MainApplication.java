package com.drivingschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Main entry point for the Driving School Spring Boot application.
 * @SpringBootApplication  - enables auto-configuration
 * @ServletComponentScan   - enables @WebServlet annotations on all Servlet classes
 */
@SpringBootApplication
@ServletComponentScan
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
