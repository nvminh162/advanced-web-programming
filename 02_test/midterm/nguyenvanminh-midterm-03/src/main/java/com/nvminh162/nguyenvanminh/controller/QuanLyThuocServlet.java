package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.dao.QuanLyLoaiThuocDAO;
import com.nvminh162.nguyenvanminh.dao.QuanLyThuocDAO;
import com.nvminh162.nguyenvanminh.model.Thuoc;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/thuoc")
public class QuanLyThuocServlet extends HttpServlet {
    private QuanLyThuocDAO quanLyThuocDAO;
    private QuanLyLoaiThuocDAO quanLyLoaiThuocDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        quanLyThuocDAO = new QuanLyThuocDAO();
        quanLyLoaiThuocDAO = new QuanLyLoaiThuocDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String maLoai = request.getParameter("ma-loai");
        if (action == null) action = "danh-sach-thuoc";
        switch (action) {
            case "danh-sach-thuoc" -> {
                request.setAttribute("danhSachThuoc", quanLyThuocDAO.findAll());
                request.getRequestDispatcher("/danh-sach-thuoc.jsp").forward(request, response);
            }
            case "danh-sach-loai-thuoc" -> {
                request.setAttribute("danhSachLoaiThuoc", quanLyLoaiThuocDAO.findAll());
                request.getRequestDispatcher("/danh-sach-loai-thuoc.jsp").forward(request, response);
            }
            case "danh-sach-thuoc-thuoc-loai-thuoc" -> {
                request.setAttribute("danhSachThuoc", quanLyThuocDAO.findAllByLoaiThuoc(Long.parseLong(maLoai)));
                request.getRequestDispatcher("/danh-sach-thuoc.jsp").forward(request, response);
            }
            case "them-thuoc" -> {
                request.setAttribute("danhSachLoaiThuoc", quanLyLoaiThuocDAO.findAll());
                request.getRequestDispatcher("/them-thuoc.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenThuoc = request.getParameter("ten-thuoc");
        String gia = request.getParameter("gia");
        String namSX = request.getParameter("nam-sx");
        String maLoai = request.getParameter("ma-loai");
        quanLyThuocDAO.save(new Thuoc(null, tenThuoc, Double.parseDouble(gia), Integer.parseInt(namSX), quanLyLoaiThuocDAO.findById(Long.parseLong(maLoai))));
        response.sendRedirect("thuoc");
    }
}
