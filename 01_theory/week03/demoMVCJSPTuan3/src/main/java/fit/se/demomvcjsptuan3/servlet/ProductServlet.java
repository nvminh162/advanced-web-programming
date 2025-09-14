package fit.se.demomvcjsptuan3.servlet;

import fit.se.demomvcjsptuan3.dao.ProductDAO;
import fit.se.demomvcjsptuan3.model.Product;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    @Resource(name = "jdbc/MariaDB")
    static DataSource ds = null;
    ProductDAO productDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDAO = new ProductDAO(ds);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> lstpro = productDAO.getAllProduct();
        req.setAttribute("lstproduct", lstpro);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/product.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // List<Product> lstpro = productDAO.getAllProduct();
        String name = req.getParameter("namepro");
        Double price =  (Double.parseDouble( req.getParameter("pricepro")));
        String description = req.getParameter("despro");

        Product pnew= new Product(name,description,price);
        //lstpro.add(pnew);
        try {
            productDAO.addProduct(pnew);
            resp.sendRedirect(req.getContextPath()+"/product");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
