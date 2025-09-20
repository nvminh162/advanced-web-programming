package com.nvminh162.nguyenvanminhc03ex03.servlet;

import com.nvminh162.nguyenvanminhc03ex03.dao.ProductDAO;
import com.nvminh162.nguyenvanminhc03ex03.model.Cart;
import com.nvminh162.nguyenvanminhc03ex03.model.Product;
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
    private ProductDAO productDAO;
    @Resource(name = "jdbc/nguyenvanminh-c03-ex03")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            productDAO = new ProductDAO(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");

        try {
            if ("add".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                Product p = productDAO.getProductById(id);
                cart.addProductToCart(p);
            } else if ("update".equals(action)) {
                int id = Integer.parseInt(req.getParameter("productId"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                cart.updateQuantityFromCart(id, quantity);
            } else if ("remove".equals(action)) {
                int id = Integer.parseInt(req.getParameter("productId"));
                cart.removeProductFromCart(id);
            } else if ("clear".equals(action)) {
                cart.clearCart();
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }

        resp.sendRedirect(req.getContextPath() + "/cart");
    }

}
