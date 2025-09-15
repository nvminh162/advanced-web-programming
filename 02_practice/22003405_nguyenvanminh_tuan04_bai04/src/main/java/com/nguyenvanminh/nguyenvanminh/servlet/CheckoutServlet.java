package com.nguyenvanminh.nguyenvanminh.servlet;

import com.nguyenvanminh.nguyenvanminh.model.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    public void init() {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/WEB-INF/views/thanhtoan.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Get form data
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String paymentMethod = request.getParameter("paymentMethod");
        String totalPrice = request.getParameter("totalPrice");

        // Get cart from session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        try (java.io.PrintWriter out = response.getWriter()) {
            // HTML Header
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>Đặt hàng thành công - IUH Bookstore</title>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("<style>");
            out.println(".container { max-width: 700px; margin: 40px auto; padding: 20px; }");
            out.println(".success { color: #28a745; text-align: center; margin-bottom: 25px; }");
            out.println(".info-box { background: #f8f9fa; padding: 15px; border-radius: 5px; margin: 15px 0; }");
            out.println("</style>");
            out.println("</head><body>");

            // Success Message
            out.println("<div class='container'>");
            out.println("<div class='success'>");
            out.println("<h2>Đặt hàng thành công!</h2>");
            out.println("</div>");

            // Customer Info
            out.println("<div class='info-box'>");
            out.println("<p><b>Họ tên:</b> " + (fullname != null ? fullname : "N/A") + "</p>");
            out.println("<p><b>Địa chỉ:</b> " + (address != null ? address : "N/A") + "</p>");
            out.println("<p><b>Thanh toán:</b> " + (paymentMethod != null ? paymentMethod.toUpperCase() : "N/A") + "</p>");
            out.println("<p><b>Tổng tiền:</b> <span class='text-success fw-bold'>" +
                       (totalPrice != null ? String.format("%,.0f", Double.parseDouble(totalPrice)) + " VND" : "0 VND") + "</span></p>");
            out.println("</div>");

            // Cart Items
            if (cart != null && !cart.getCartItems().isEmpty()) {
                out.println("<div class='info-box'>");
                out.println("<table class='table table-sm'>");
                out.println("<tr><th>Sách</th><th>Tác giả</th><th>SL</th><th>Giá</th></tr>");
                for (com.nguyenvanminh.nguyenvanminh.model.CartItem item : cart.getCartItems()) {
                    out.println("<tr>");
                    out.println("<td>" + item.getBook().getName() + "</td>");
                    out.println("<td>" + item.getBook().getAuthor() + "</td>");
                    out.println("<td>" + item.getQuantity() + "</td>");
                    out.println("<td>" + String.format("%,.0f VND", item.getSubTotal()) + "</td>");
                    out.println("</tr>");
                }
                out.println("<tr>");
                out.println("<td colspan='3'><b>Tổng cộng:</b></td>");
                out.println("<td><b>" + String.format("%,.0f VND", cart.getTotalPrice()) + "</b></td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</div>");

                // Clear cart
                cart.clearCart();
                session.setAttribute("cart", cart);
            }

            // Action Buttons
            out.println("<div class='text-center mt-3'>");
            out.println("<a href='" + request.getContextPath() + "/books' class='btn btn-primary me-2'>Tiếp tục mua sắm</a>");
            out.println("</div>");

            out.println("</div></body></html>");
        }
    }
}
