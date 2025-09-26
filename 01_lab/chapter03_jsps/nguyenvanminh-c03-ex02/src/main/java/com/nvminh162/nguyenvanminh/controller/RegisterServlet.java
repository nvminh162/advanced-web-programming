package com.nvminh162.nguyenvanminh.controller;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

import com.nvminh162.nguyenvanminh.model.Account;
import com.nvminh162.nguyenvanminh.util.AccountUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private AccountUtil accountUtil;
    @Resource(name = "jdbc/www_c03_ex02")
    private DataSource dataSource;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            accountUtil = new AccountUtil(dataSource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/Form.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        int day = Integer.parseInt(req.getParameter("day"));
        int month = Integer.parseInt(req.getParameter("month"));
        int year = Integer.parseInt(req.getParameter("year"));

        LocalDate localDate = LocalDate.of(year, month, day);
        java.sql.Date dob = java.sql.Date.valueOf(localDate);

        Account account = new Account(firstname, lastname, email, password, dob.toLocalDate());
        try {
            accountUtil.addAccount(account);
            List<Account> accounts = accountUtil.getAccounts();
            req.setAttribute("accounts", accounts);
            RequestDispatcher rd = req.getRequestDispatcher("Accounts.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void destroy() {
    }
}
