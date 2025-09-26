package com.nvminh162.nguyenvanminhc03ex03.servlet;

import com.nvminh162.nguyenvanminhc03ex03.dao.ProductDAO;
import com.nvminh162.nguyenvanminhc03ex03.model.Product;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet({"/product", "/products"})
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;
    @Resource(name = "jdbc/nguyenvanminh-c03-ex03")
    private DataSource dataSource;

    @Override
    public void init() {
        productDAO = new ProductDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            Product product = productDAO.getProductById(id);
            if (product != null) {
                request.setAttribute("product", product);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/product-detail.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
                return;
            }
        }
        List<Product> products = productDAO.getAllProducts();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/product-list.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {}
}
