package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.dao.CatalogDAO;
import com.nvminh162.nguyenvanminh.model.Catalog;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/catalogs")
public class CatalogServlet extends HttpServlet {

    private CatalogDAO catalogDAO;
    @Resource(name = "jdbc/www_c03_ex06")
    private DataSource dataSource;

    @Override
    public void init() {
        this.catalogDAO = new CatalogDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                request.getRequestDispatcher("/catalog/catalog-create.jsp").forward(request, response);
                break;
            case "update":
                String danhMucIdUpdate = request.getParameter("danh-muc-id");
                Catalog catalog = catalogDAO.findById(Long.parseLong(danhMucIdUpdate));
                request.setAttribute("catalog", catalog);
                request.getRequestDispatcher("/catalog/catalog-update.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("catalogList", catalogDAO.findAll());
                request.getRequestDispatcher("/catalog/catalog-list.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                String tenDanhMucCreate = request.getParameter("ten-danh-muc");
                String nguoiQuanLyCreate = request.getParameter("nguoi-quan-ly");
                String ghiChuCreate = request.getParameter("ghi-chu");
                catalogDAO.addCatalog(new Catalog(null, tenDanhMucCreate, nguoiQuanLyCreate, ghiChuCreate));
                response.sendRedirect("catalogs");
                break;
            case "update":
                String danhMucIdUpdate = request.getParameter("danh-muc-id");
                String tenDanhMucUpdate = request.getParameter("ten-danh-muc");
                String nguoiQuanLyUpdate = request.getParameter("nguoi-quan-ly");
                String ghiChuUpdate = request.getParameter("ghi-chu");
                catalogDAO.updateCatalog(new Catalog(Long.parseLong(danhMucIdUpdate), tenDanhMucUpdate, nguoiQuanLyUpdate, ghiChuUpdate));
                response.sendRedirect("catalogs");
                break;
            case "delete":
                String danhMucIdDelete = request.getParameter("danh-muc-id");
                catalogDAO.deleteCatalog(Long.parseLong(danhMucIdDelete));
                response.sendRedirect("catalogs");
                break;
            default:
                break;
        }
    }
}