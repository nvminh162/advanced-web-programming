package com.nvminh162.nguyenvanminh.servlet;

import com.nvminh162.nguyenvanminh.dao.BookDAO;
import com.nvminh162.nguyenvanminh.model.Book;
import com.nvminh162.nguyenvanminh.model.Cart;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet({"/payment"})
public class PaymentServlet extends HttpServlet {
    private BookDAO bookDAO;
    @Resource(name = "jdbc/www_c03_ex04")
    private DataSource dataSource;

    @Override
    public void init() {
        bookDAO = new BookDAO(dataSource);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/payment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        double totalAmount = Double.parseDouble(request.getParameter("totalAmountDouble"));
        String payment = request.getParameter("payment");

        // Print thông tin đơn hàng
        System.out.println("Full Name: " + fullName);
        System.out.println("Address: " + address);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Payment Method: " + payment);

        // Clear cart
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        // Tạo copy của cartItems để tránh ConcurrentModificationException
        if (cart != null && cart.getCartItems() != null) {
            cart.getCartItems()
                    .forEach(it -> {
                        Book book = bookDAO.getBookById(it.getBook().getId());
                        int newQuantity = book.getQuantity() - it.getQuantity();
                        bookDAO.updateBookQuantityById(it.getBook().getId(), newQuantity);
                    });

            // Clear cart after updating stock
            cart.clearCart();
            session.setAttribute("cart", cart);
        }


        // Response đơn giản
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Order Successful!</h1>");
        response.getWriter().println("<p>Thank you " + fullName + " for your order!</p>");
        response.getWriter().println("<p>Total: " + totalAmount + " VND</p>");
        response.getWriter().println("<a href='" + request.getContextPath() + "/books'>Continue Shopping</a>");
    }
}
