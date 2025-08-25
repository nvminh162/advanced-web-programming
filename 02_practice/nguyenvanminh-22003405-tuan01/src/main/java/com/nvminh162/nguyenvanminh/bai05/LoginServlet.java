package com.nvminh162.nguyenvanminh.bai05;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/bai05/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // username = admin, password=123
        if ("admin".equals(username) && "123".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            resp.sendRedirect(req.getContextPath() + "/bai05/Home.jsp");
        } else {
            req.setAttribute("error", "Sai tài khoản");
            req.getRequestDispatcher("/bai05/Login.jsp").forward(req, resp);
        }
    }
}

