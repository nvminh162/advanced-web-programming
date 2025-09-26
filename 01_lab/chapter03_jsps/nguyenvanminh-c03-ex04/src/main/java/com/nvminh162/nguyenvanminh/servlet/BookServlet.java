package com.nvminh162.nguyenvanminh.servlet;

import com.nvminh162.nguyenvanminh.dao.BookDAO;
import com.nvminh162.nguyenvanminh.model.Book;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet({"/book", "/books"})
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO;
    @Resource(name = "jdbc/www_c03_ex04")
    private DataSource dataSource;

    @Override
    public void init() {
        bookDAO = new BookDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Nếu truyền lên param book id thì redirect sang book-detail.jsp
        String paramBookId = request.getParameter("id");
        if (paramBookId != null) {
            int bookId = Integer.parseInt(paramBookId);
            var book = bookDAO.getBookById(bookId);
            request.setAttribute("book", book);
            request.getRequestDispatcher("/book-detail.jsp").forward(request, response);
            return;
        }

        String searchName = request.getParameter("searchName");
        List<Book> books;
        if (searchName != null && !searchName.trim().isEmpty()) {
            books = bookDAO.searchBooksByName(searchName);
        } else {
            books = bookDAO.getAllBooks();
        }
        request.setAttribute("books", books);
        request.getRequestDispatcher("/books.jsp").forward(request, response);
    }
}
