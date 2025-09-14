package com.nvminh162.nguyenvanminh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    public boolean addUser(User user) throws SQLException {
        String sql = "INSERT INTO users (FIRSTNAME, LASTNAME, PICFILE) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            // Kết nối CSDL: jdbc kết nối CSDL
            conn = DatabaseConfig.getConnection();

            // Insert dữ liệu vào bảng gồm cả dữ liệu Text và dữ liệu Image
            statement = conn.prepareStatement(sql);

            // Set parameters
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPicFile());

            // Execute the update
            int result = statement.executeUpdate();

            return result > 0;

        } finally {
            // Clean up resources
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseConfig.closeConnection(conn);
        }
    }
}
