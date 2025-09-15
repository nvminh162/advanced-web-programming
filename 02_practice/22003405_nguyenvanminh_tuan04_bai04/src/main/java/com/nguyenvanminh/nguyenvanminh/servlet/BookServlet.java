package com.nguyenvanminh.nguyenvanminh.servlet;

import com.nguyenvanminh.nguyenvanminh.dao.BookDAO;
import com.nguyenvanminh.nguyenvanminh.model.Book;
import com.nguyenvanminh.nguyenvanminh.model.Cart;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet({"/book", "/books"})
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO;
    @Resource(name = "jdbc/nguyenvanminh22003405_ex03")
    private DataSource dataSource;

    @Override
    public void init() {
        this.bookDAO = new BookDAO(dataSource);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        String bookIdParam = request.getParameter("id");
        String searchKeyword = request.getParameter("search");

        // Handle individual book view
        if (bookIdParam != null) {
            int bookId = Integer.parseInt(bookIdParam);
            Book book = bookDAO.getBookById(bookId);
            if (book != null) {
                request.setAttribute("book", book);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/chitietsach.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Book not found");
                return;
            }
        }

        // Handle search or show all books
        List<Book> books;
        if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
            books = bookDAO.searchBooksByName(searchKeyword.trim());
            request.setAttribute("searchKeyword", searchKeyword);
        } else {
            books = bookDAO.getAllBooks();
        }

        request.setAttribute("books", books);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/danhsach.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void destroy() {
    }
}
