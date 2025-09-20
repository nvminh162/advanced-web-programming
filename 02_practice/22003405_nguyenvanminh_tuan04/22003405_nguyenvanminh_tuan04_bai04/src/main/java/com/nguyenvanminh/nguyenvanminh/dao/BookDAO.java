package com.nguyenvanminh.nguyenvanminh.dao;

import com.nguyenvanminh.nguyenvanminh.model.Book;
import com.nguyenvanminh.nguyenvanminh.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final DBUtil dbUtil;

    public BookDAO(DataSource dataSource) {
        this.dbUtil = new DBUtil(dataSource);
    }

    // Get All Books
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = """
                SELECT * FROM books;
                """;
        try (Connection conn = dbUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                Book book = new Book(id, name, author, image, price, quantity);
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book getBookById(int id) {
        String sql = """
                SELECT * FROM books WHERE id = ?;
                """;
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    return new Book(id, name, author, image, price, quantity);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // Search books by name using LIKE
    public List<Book> searchBooksByName(String keyword) {
        List<Book> books = new ArrayList<>();
        String sql = """
                SELECT * FROM books WHERE name LIKE ?;
                """;
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    Book book = new Book(id, name, author, image, price, quantity);
                    books.add(book);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
