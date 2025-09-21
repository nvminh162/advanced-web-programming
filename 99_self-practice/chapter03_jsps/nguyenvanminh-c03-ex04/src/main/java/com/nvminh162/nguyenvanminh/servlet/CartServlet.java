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

@WebServlet({"/cart"})
public class CartServlet extends HttpServlet {
    private BookDAO bookDAO;
    @Resource(name = "jdbc/www_c03_ex04")
    private DataSource dataSource;

    @Override
    public void init() {
        bookDAO = new BookDAO(dataSource);
    }

    /*
    Vì sao ko cần gọi session vẫn có khi reload
    EL ${cart.cartItems} sẽ tìm kiếm theo thứ tự:
    pageContext.getAttribute("cart") - không có
    request.getAttribute("cart") - không có (vì doGet không set)
    session.getAttribute("cart") - TÌM THẤY! ✅
    application.getAttribute("cart") - không cần tìm nữa
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        String action = request.getParameter("action");
        String bookIdParam = request.getParameter("bookId");
        String quantityParam = request.getParameter("quantity");

        switch (action) {
            case "add":
                int addBoodId = Integer.parseInt(bookIdParam);
                int quantity = quantityParam != null ? Integer.parseInt(quantityParam) : 1;
                Book book = bookDAO.getBookById(addBoodId);
                cart.addBookToCart(book, quantity);
                break;
            case "update":
                int updateBookId = Integer.parseInt(bookIdParam);
                int updateQuantity = quantityParam != null ? Integer.parseInt(quantityParam) : 1;
                cart.updateQuantityBookInCart(updateBookId, updateQuantity);
                break;
            case "remove":
                int removeBookId = Integer.parseInt(bookIdParam);
                cart.removeBookFromCart(removeBookId);
                break;
            case "clear":
                cart.clearCart();
                break;
        }

        session.setAttribute("cart", cart);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
}
