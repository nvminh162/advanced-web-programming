package com.nvminh162.nvminh162;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    static Connection connection = null;

//    @Resource(name = "jdbc/mssql") // JNDI name
//    static DataSource dataSource = null;
    static String url = "jdbc:mysql://localhost:3306/www_week04";
    static  String user = "root";
    static   String password = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Ket noi thanh cong" + connection.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
