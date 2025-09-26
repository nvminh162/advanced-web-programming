package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet({"/book", "/books"})
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String name = request.getParameter("name");
        if (action == null) action = "list";
        switch (action) {
            case "list" -> {
                request.setAttribute("books", bookDAO.findAll());
                request.getRequestDispatcher("/books.jsp").forward(request, response);
            }
            case "detail" -> {
                UUID id = UUID.fromString(request.getParameter("id"));
                System.out.println(id);
                request.setAttribute("book", bookDAO.findById(id));
                request.getRequestDispatcher("/book.jsp").forward(request, response);
            }
            case "search" -> {
                request.setAttribute("books", bookDAO.findByName(name));
                request.getRequestDispatcher("/books.jsp").forward(request, response);
            }
            default -> response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
