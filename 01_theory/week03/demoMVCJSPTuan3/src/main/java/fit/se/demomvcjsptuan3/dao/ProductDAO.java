package fit.se.demomvcjsptuan3.dao;

import fit.se.demomvcjsptuan3.model.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    static private Connection con = null;

    static DataSource dataSource = null;


    public ProductDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<Product>();
        Statement stmt = null;
        String sql = "select * from product";
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                String des = rs.getString("description");

                Product p = new Product(id,
                        name,
                        price,
                        des);
                list.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void addProduct(Product p) throws SQLException {
        String sql = "insert into product(NAME,DESCRIPTION,PRICE) values(?,?,?)";
        PreparedStatement pstmt = null;
        con = dataSource.getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, p.getName());
        pstmt.setString(2, p.getDescription());
        pstmt.setDouble(3, p.getPrice());

        pstmt.executeUpdate();
    }
}
