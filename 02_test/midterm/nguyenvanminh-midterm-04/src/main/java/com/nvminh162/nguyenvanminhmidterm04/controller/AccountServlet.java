package com.nvminh162.nguyenvanminhmidterm04.controller;

import com.nvminh162.nguyenvanminhmidterm04.dao.AccountDAO;
import com.nvminh162.nguyenvanminhmidterm04.model.Account;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/accounts")
public class AccountServlet extends HttpServlet {
    private AccountDAO accountDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        accountDAO = new AccountDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "account-list";
        switch (action) {
            case "account-list" -> {
                request.setAttribute("accounts", accountDAO.findAll());
                request.getRequestDispatcher("/account-list.jsp").forward(request, response);
            }
            case "account-form" -> {
                request.getRequestDispatcher("/account-form.jsp").forward(request, response);
            }
            case "filter-address" -> {
                String address = request.getParameter("filter-address");
                request.setAttribute("accounts", accountDAO.findByAddress(address));
                request.getRequestDispatcher("/account-list.jsp").forward(request, response);
            }
            case "filter-amount-range" -> {
                String minParam = request.getParameter("filter-amount-min");
                String maxParam = request.getParameter("filter-amount-max");
                double min = (minParam == null || minParam.isBlank()) ? 0 : Double.parseDouble(minParam);
                double max = (maxParam == null || maxParam.isBlank()) ? Double.MAX_VALUE : Double.parseDouble(maxParam);
                request.setAttribute("accounts", accountDAO.findAmountByInRangeUnlimit(min, max));
                request.getRequestDispatcher("/account-list.jsp").forward(request, response);
            }

            default -> response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ownerName = request.getParameter("owner-name");
        String cardNumber = request.getParameter("card-number");
        String ownerAddress = request.getParameter("owner-address");
        String amount = request.getParameter("amount");
        accountDAO.save(new Account(null, ownerName, Integer.parseInt(cardNumber), ownerAddress, Double.parseDouble(amount)));
        response.sendRedirect("accounts");
    }
}
