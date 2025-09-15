package com.nvminh162.nguyenvanminh.util;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import javax.sql.DataSource;
import com.nvminh162.nguyenvanminh.model.Account;

public class AccountUtil {

    private final DataSource datasource;

    public AccountUtil(DataSource datasource) throws Exception {
        this.datasource = datasource;
    }

    // lay danh sach account
    public List<Account> getAccounts() throws Exception {
        List<Account> accounts = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = datasource.getConnection();
            String sql = "SELECT * FROM accounts ORDER BY ID";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String fname = rs.getString("FIRSTNAME");
                String lname = rs.getString("LASTNAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                LocalDate dateofbirth = rs.getDate("DATEOFBIRTH").toLocalDate();
                Account acc = new Account(fname, lname, email, password, dateofbirth);
                acc.setId(id);
                accounts.add(acc);
            }

            return accounts;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Them account
    public void addAccount(Account acc) throws Exception {
        String sql = "INSERT INTO accounts (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, DATEOFBIRTH) " +
                    "VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = datasource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getFirstName());
            ps.setString(2, acc.getLastName());
            ps.setString(3, acc.getEmail());
            ps.setString(4, acc.getPassword());
            ps.setDate(5, Date.valueOf(acc.getDateOfBirth()));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
