package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.dao.DepartmentDAO;
import com.nvminh162.nguyenvanminh.model.Department;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet({"/department", "/departments"})
public class DepartmentServlet extends HttpServlet {
    private DepartmentDAO departmentDAO;
    @Resource(name = "jdbc/www_c03_ex05")
    private DataSource dataSource;

    @Override
    public void init() {
        departmentDAO = new DepartmentDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departmentName = request.getParameter("department-name");
        List<Department> departments;
        if (departmentName != null) {
            departments = departmentDAO.findByName(departmentName);
        } else {
            departments = departmentDAO.findAll();
        }
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("/departments.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) return;
        switch (action) {
            case "delete":
                Long deleteDeptId = Long.parseLong(request.getParameter("departmentId"));
                departmentDAO.deleteById(deleteDeptId);
                break;
        }
        response.sendRedirect(request.getContextPath() + "/departments");
    }
}
