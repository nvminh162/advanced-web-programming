package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.bean.Cart;
import com.nvminh162.nguyenvanminh.dao.BookDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private BookDAO bookDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");
        UUID bookId = UUID.fromString(request.getParameter("book-id"));
        String quantity = request.getParameter("quantity");

        switch (action) {
            case "create" -> {
                cart.add(bookDAO.findById(bookId));
            }
            case "remove" -> {
                cart.remove(bookId);
            }
            case "update" -> {
                cart.update(bookId, Integer.parseInt(quantity));
            }
        }
        response.sendRedirect("cart");
    }
}
