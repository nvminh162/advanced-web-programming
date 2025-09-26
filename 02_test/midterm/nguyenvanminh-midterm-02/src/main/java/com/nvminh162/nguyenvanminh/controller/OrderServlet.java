package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.bean.Cart;
import com.nvminh162.nguyenvanminh.dao.BookDAO;
import com.nvminh162.nguyenvanminh.dao.OrderDAO;
import com.nvminh162.nguyenvanminh.model.Book;
import com.nvminh162.nguyenvanminh.model.Order;
import com.nvminh162.nguyenvanminh.model.PaymentMethod;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private OrderDAO orderDAO;
    private BookDAO bookDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        orderDAO = new OrderDAO();
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
        request.getRequestDispatcher("/checkout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("full-name");
        String address = request.getParameter("address");
        String totalAmount = request.getParameter("total-amount");
        String paymentMethod = request.getParameter("payment-method");
        orderDAO.save(Order.builder()
                .name(fullName)
                .address(address)
                .paymentMethod(PaymentMethod.valueOf(paymentMethod))
                .total(Double.parseDouble(totalAmount))
                .build());
        // clear cart
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.getCartItems().forEach(it -> {
            Book book = bookDAO.findById(it.getBook().getId());
            book.setQuantity(book.getQuantity() - it.getQuantity());
            bookDAO.save(book);
        });
        cart.clear();
        response.sendRedirect("books");
    }
}

