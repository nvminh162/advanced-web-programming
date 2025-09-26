package com.nvminh162.nguyenvanminh.dao;

import com.nvminh162.nguyenvanminh.model.Book;
import com.nvminh162.nguyenvanminh.util.DBUtil;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDAO {
    DBUtil dbUtil;

    public BookDAO(DataSource dataSource) {
        dbUtil = new DBUtil(dataSource);
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE quantity > 0";
        try (Connection connection = dbUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)
        ) {
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                books.add(new Book(id, name, author, image, price, quantity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book getBookById(Integer id) {
        String sql = "SELECT * FROM books WHERE id = ? AND quantity > 0";
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    String image = rs.getString("image");
                    Double price = rs.getDouble("price");
                    Integer quantity = rs.getInt("quantity");
                    return new Book(id, name, author, image, price, quantity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateBookQuantityById(Integer bookId, Integer quantity) {
        String sql = "UPDATE books SET quantity = ? WHERE id = ? AND quantity > 0";
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, quantity);
            statement.setInt(2, bookId);
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Search books by name using LIKE
    public List<Book> searchBooksByName(String keyword) {
        List<Book> books = new ArrayList<>();
        String sql = """
                SELECT * FROM books WHERE name LIKE ? AND quantity > 0;
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
