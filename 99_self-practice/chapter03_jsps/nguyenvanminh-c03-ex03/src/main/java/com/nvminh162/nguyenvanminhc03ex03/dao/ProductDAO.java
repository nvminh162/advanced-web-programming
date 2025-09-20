package com.nvminh162.nguyenvanminhc03ex03.dao;

import com.nvminh162.nguyenvanminhc03ex03.model.Product;
import com.nvminh162.nguyenvanminhc03ex03.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private DBUtil dbUtil;

    public ProductDAO(DataSource dataSource) {
        dbUtil = new DBUtil(dataSource);
    }

    // READ ALL
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection conn = dbUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Integer id = rs.getInt("ID");
                String model = rs.getString("MODEL");
                Double price = rs.getDouble("PRICE");
                Integer quantity = rs.getInt("QUANTITY");
                String image = rs.getString("IMGURL");
                String description = rs.getString("DESCRIPTION");
                Product p = new Product(id, model, price, quantity, description, image);
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // READ BY ID
    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE ID=?";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Integer proid = rs.getInt("ID");
                    String model = rs.getString("MODEL");
                    Double price = rs.getDouble("PRICE");
                    Integer quantity = rs.getInt("QUANTITY");
                    String image = rs.getString("IMGURL");
                    String description = rs.getString("DESCRIPTION");

                    return new Product(proid, model, price, quantity, description, image);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
