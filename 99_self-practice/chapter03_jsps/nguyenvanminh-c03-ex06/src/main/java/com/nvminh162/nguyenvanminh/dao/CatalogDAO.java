package com.nvminh162.nguyenvanminh.dao;


import com.nvminh162.nguyenvanminh.model.Catalog;
import com.nvminh162.nguyenvanminh.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAO {
    private final DBUtil dbUtil;

    public CatalogDAO(DataSource dataSource) {
        this.dbUtil = new DBUtil(dataSource);
    }

    public List<Catalog> findAll() {
        List<Catalog> catalogList = new ArrayList<>();
        String sql = """
                SELECT * FROM catalog
                """;
        try (Connection connection = dbUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql);
        ) {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String ten_danh_muc = rs.getString("ten_danh_muc");
                String nguoi_quan_ly = rs.getString("nguoi_quan_ly");
                String ghi_chu = rs.getString("ghi_chu");
                catalogList.add(new Catalog(id, ten_danh_muc, nguoi_quan_ly, ghi_chu));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return catalogList;
    }

    public void addCatalog(Catalog catalog) {
        String sql = """
                INSERT INTO catalog (ten_danh_muc, nguoi_quan_ly, ghi_chu) VALUES (?, ?, ?)
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setString(1, catalog.getTenDanhMuc());
            pstmt.setString(2, catalog.getNguoiQuanLy());
            pstmt.setString(3, catalog.getGhiChu());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Catalog findById(Long id) {
        String sql = """
                SELECT * FROM catalog WHERE id = ?
                """;
        try (Connection connection = dbUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String ten_danh_muc = rs.getString("ten_danh_muc");
                    String nguoi_quan_ly = rs.getString("nguoi_quan_ly");
                    String ghi_chu = rs.getString("ghi_chu");
                    return new Catalog(id, ten_danh_muc, nguoi_quan_ly, ghi_chu);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void updateCatalog(Catalog catalog) {
        String sql = """
                UPDATE catalog SET ten_danh_muc = ?, nguoi_quan_ly = ?, ghi_chu = ? WHERE id = ?
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setString(1, catalog.getTenDanhMuc());
            pstmt.setString(2, catalog.getNguoiQuanLy());
            pstmt.setString(3, catalog.getGhiChu());
            pstmt.setLong(4, catalog.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCatalog(Long id) {
        String sql = """
                DELETE FROM catalog WHERE id = ?
                """;
        try (Connection connection = dbUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
