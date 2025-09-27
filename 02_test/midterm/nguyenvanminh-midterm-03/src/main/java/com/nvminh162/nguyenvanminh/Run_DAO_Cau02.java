package com.nvminh162.nguyenvanminh;

import com.nvminh162.nguyenvanminh.dao.QuanLyLoaiThuocDAO;
import com.nvminh162.nguyenvanminh.dao.QuanLyThuocDAO;
import com.nvminh162.nguyenvanminh.model.LoaiThuoc;
import com.nvminh162.nguyenvanminh.model.Thuoc;
import com.nvminh162.nguyenvanminh.util.JPAUtil;

public class Run_DAO_Cau02 {
    public static void main(String[] args) {
        JPAUtil.init();

        QuanLyThuocDAO quanLyThuocDAO = new QuanLyThuocDAO();
        QuanLyLoaiThuocDAO quanLyLoaiThuocDAO = new QuanLyLoaiThuocDAO();

        // 3.a
        quanLyThuocDAO.findAll().forEach(System.out::println);
        // 3.b
        quanLyLoaiThuocDAO.findAll().forEach(System.out::println);
        // 3.c
        quanLyThuocDAO.findAllByLoaiThuoc(1L).forEach(System.out::println);
        // 3.d
        LoaiThuoc loaiThuoc = quanLyLoaiThuocDAO.findById(1L);
        quanLyThuocDAO.save(new Thuoc(null, "Thuốc ngủ", 100000, 2025, loaiThuoc));

        JPAUtil.close();
    }
}
