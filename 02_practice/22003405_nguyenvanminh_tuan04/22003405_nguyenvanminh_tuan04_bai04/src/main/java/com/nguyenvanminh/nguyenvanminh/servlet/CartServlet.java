package com.nguyenvanminh.nguyenvanminh.servlet;

import com.nguyenvanminh.nguyenvanminh.dao.BookDAO;
import com.nguyenvanminh.nguyenvanminh.model.Book;
import com.nguyenvanminh.nguyenvanminh.model.Cart;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private BookDAO bookDAO;
    @Resource(name = "jdbc/nguyenvanminh22003405_ex03")
    private DataSource dataSource;

    @Override
    public void init() {
        this.bookDAO = new BookDAO(dataSource);
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
        request.getRequestDispatcher("/WEB-INF/views/giohang.jsp").forward(request, response);
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
        System.out.println(action);

        try {
            if ("add".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Book book = bookDAO.getBookById(id);
                System.out.println(book);
                cart.addBookToCart(book);
            } else if ("update".equals(action)) {
                int id = Integer.parseInt(request.getParameter("bookId"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                cart.updateBookInCart(id, quantity);
            } else if ("remove".equals(action)) {
                int id = Integer.parseInt(request.getParameter("bookId"));
                cart.removeBookFromCart(id);
            } else if ("clear".equals(action)) {
                cart.clearCart();
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        response.sendRedirect("cart");
    }
}
