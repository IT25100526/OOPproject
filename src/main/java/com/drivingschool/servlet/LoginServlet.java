package com.drivingschool.servlet;

import com.drivingschool.model.UserAccount;
import com.drivingschool.util.FileHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String USERS_FILE = "data/users.txt";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserAccount user = authenticate(username, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("loggedUser", user);
            session.setAttribute("role", user.getRole());
            res.sendRedirect(req.getContextPath() + "/dashboard.jsp");
        } else {
            req.setAttribute("error", "Invalid username or password.");
            req.getRequestDispatcher("/login.jsp").forward(req, res);
        }
    }

    private UserAccount authenticate(String username, String password) throws IOException {
        File file = new File(USERS_FILE);
        if (!file.exists()) return null;

        // Simple MD5-style hash comparison (use BCrypt in production)
        String inputHash = Integer.toHexString(password.hashCode());

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                UserAccount u = UserAccount.fromFileString(line);
                if (u != null && u.getUsername().equals(username)
                        && u.getPasswordHash().equals(inputHash)) {
                    return u;
                }
            }
        }
        return null;
    }
}
