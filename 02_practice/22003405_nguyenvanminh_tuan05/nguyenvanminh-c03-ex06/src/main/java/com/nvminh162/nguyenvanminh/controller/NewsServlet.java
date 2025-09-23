package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.dao.CatalogDAO;
import com.nvminh162.nguyenvanminh.dao.NewsDAO;
import com.nvminh162.nguyenvanminh.model.Catalog;
import com.nvminh162.nguyenvanminh.model.News;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    private CatalogDAO catalogDAO;
    private NewsDAO newsDAO;
    @Resource(name = "jdbc/www_c03_ex06")
    private DataSource dataSource;

    @Override
    public void init() {
        this.catalogDAO = new CatalogDAO(dataSource);
        this.newsDAO = new NewsDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                request.setAttribute("catalogList", catalogDAO.findAll());
                request.getRequestDispatcher("/news/news-create.jsp").forward(request, response);
            case "update":
                String tintucIdUpdate = request.getParameter("tintuc-id");
                request.setAttribute("news", newsDAO.findById(Long.parseLong(tintucIdUpdate)));
                request.setAttribute("catalogList", catalogDAO.findAll());
                request.getRequestDispatcher("/news/news-update.jsp").forward(request, response);
            default:
                String danhMucId = request.getParameter("danh-muc-id");
                request.setAttribute("newsList", newsDAO.findNewsByCatalog(Long.parseLong(danhMucId)));
                request.getRequestDispatcher("/news/news-list.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                String tieuDeCreate = request.getParameter("tieu-de");
                String noiDungTTCreate = request.getParameter("noi-dung-tt");
                String lienKetCreate = request.getParameter("lien-ket");
                String tinTucDanhMucIdCreate = request.getParameter("tintuc-danhmuc-id");
                Catalog catalog = catalogDAO.findById(Long.parseLong(tinTucDanhMucIdCreate));
                newsDAO.addNews(new News(null, tieuDeCreate, noiDungTTCreate, lienKetCreate, catalog));
                response.sendRedirect("catalogs");
                break;
            case "update":
                String tintucIdUpdate = request.getParameter("tin-tuc-id");
                String tieuDeUpdate = request.getParameter("tieu-de");
                String noiDungTTUpdate = request.getParameter("noi-dung-tt");
                String lienKetUpdate = request.getParameter("lien-ket");
                String tinTucDanhMucIdUpdate = request.getParameter("tintuc-danhmuc-id");
                Catalog catalogUpdate = catalogDAO.findById(Long.parseLong(tinTucDanhMucIdUpdate));
                newsDAO.updateNews(new News(Long.parseLong(tintucIdUpdate), tieuDeUpdate, noiDungTTUpdate, lienKetUpdate, catalogUpdate));
                response.sendRedirect("catalogs");
                break;
            case "delete":
                String tintucIdDelete = request.getParameter("tin-tuc-id");
                newsDAO.deleteNews(Long.parseLong(tintucIdDelete));
                response.sendRedirect("catalogs");
                break;
            default:
                break;
        }
    }
}
