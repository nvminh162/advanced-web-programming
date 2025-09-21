package com.nvminh162.nguyenvanminh.dao;

import com.nvminh162.nguyenvanminh.model.Department;
import com.nvminh162.nguyenvanminh.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private DBUtil dbUtil;

    public DepartmentDAO(DataSource dataSource) {
        this.dbUtil = new DBUtil(dataSource);
    }

    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        String sql = """
                SELECT * FROM departments
                """;
        try (Connection connection = dbUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)
        ) {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                departments.add(new Department(id, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    public List<Department> findByName(String name) {
        List<Department> departments = new ArrayList<>();
        String sql = """
                SELECT * FROM departments WHERE name LIKE ?
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, "%" + name + "%");
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("id");
                    String departmentName = rs.getString("name");
                    departments.add(new Department(id, departmentName));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }

    public boolean deleteById(Long id) {
        String sql = """
                DELETE FROM departments WHERE id = ?
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement psmt = connection.prepareStatement(sql)
        ) {
            psmt.setLong(1, id);
            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
