package com.nvminh162.nguyenvanminh.dao;

import com.nvminh162.nguyenvanminh.model.Catalog;
import com.nvminh162.nguyenvanminh.model.News;
import com.nvminh162.nguyenvanminh.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
    private final DBUtil dbUtil;

    public NewsDAO(DataSource dataSource) {
        this.dbUtil = new DBUtil(dataSource);
    }

    public List<News> findNewsByCatalog(Long catalogId) {
        List<News> newsList = new ArrayList<>();
        String sql = """
                SELECT n.id, n.tieu_de, n.noi_dung_tt, n.lien_ket, n.danh_muc_id,
                       c.ten_danh_muc, c.nguoi_quan_ly, c.ghi_chu
                FROM news n
                JOIN catalog c ON n.danh_muc_id = c.id
                WHERE n.danh_muc_id = ?
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setLong(1, catalogId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("id");
                    String tieuDe = rs.getString("tieu_de");
                    String noiDungTT = rs.getString("noi_dung_tt");
                    String lienKet = rs.getString("lien_ket");

                    Long danhMucId = rs.getLong("danh_muc_id");
                    String tenDanhMuc = rs.getString("ten_danh_muc");
                    String nguoiQuanLy = rs.getString("nguoi_quan_ly");
                    String ghiChu = rs.getString("ghi_chu");
                    Catalog catalog = new Catalog(danhMucId, tenDanhMuc, nguoiQuanLy, ghiChu);
                    News news = new News(id, tieuDe, noiDungTT, lienKet, catalog);
                    newsList.add(news);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return newsList;
    }

    public void addNews(News news) {
        String sql = """
                INSERT INTO news (tieu_de, noi_dung_tt, lien_ket, danh_muc_id) VALUES (?, ?, ?, ?)
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setString(1, news.getTieuDe());
            pstmt.setString(2, news.getNoiDungTT());
            pstmt.setString(3, news.getLienKet());
            pstmt.setLong(4, news.getCatalog().getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public News findById(Long id) {
        String sql = """
                SELECT n.id, n.tieu_de, n.noi_dung_tt, n.lien_ket, n.danh_muc_id,
                       c.ten_danh_muc, c.nguoi_quan_ly, c.ghi_chu
                FROM news n
                JOIN catalog c ON n.danh_muc_id = c.id
                WHERE n.id = ?
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String tieuDe = rs.getString("tieu_de");
                    String noiDungTT = rs.getString("noi_dung_tt");
                    String lienKet = rs.getString("lien_ket");

                    Long danhMucId = rs.getLong("danh_muc_id");
                    String tenDanhMuc = rs.getString("ten_danh_muc");
                    String nguoiQuanLy = rs.getString("nguoi_quan_ly");
                    String ghiChu = rs.getString("ghi_chu");
                    Catalog catalog = new Catalog(danhMucId, tenDanhMuc, nguoiQuanLy, ghiChu);
                    return new News(id, tieuDe, noiDungTT, lienKet, catalog);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void updateNews(News news) {
        String sql = """
                UPDATE news 
                SET tieu_de = ?, noi_dung_tt = ?, lien_ket = ?, danh_muc_id = ?
                WHERE id = ?
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, news.getTieuDe());
            pstmt.setString(2, news.getNoiDungTT());
            pstmt.setString(3, news.getLienKet());
            pstmt.setLong(4, news.getCatalog().getId());
            pstmt.setLong(5, news.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteNews(Long id) {
        String sql = """
                DELETE FROM news 
                WHERE id = ?
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
