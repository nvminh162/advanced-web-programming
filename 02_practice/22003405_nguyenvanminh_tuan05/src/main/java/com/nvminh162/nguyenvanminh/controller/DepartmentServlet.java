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
        // Update Department
        String departmentId = request.getParameter("department-id");
        if (departmentId != null) {
            request.setAttribute("department", departmentDAO.findById(Long.parseLong(departmentId)));
            request.getRequestDispatcher("/department-update.jsp").forward(request, response);
            return;
        }
        // Search List Departments
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) return;
        switch (action) {
            case "delete":
                Long deleteDepartmentId = Long.parseLong(request.getParameter("department-id"));
                try {
                    departmentDAO.deleteById(deleteDepartmentId);
                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Phòng ban tồn tại nhân viên, vui lòng xoá nhân viên trước khi xoá phòng ban");
                }
                break;
            case "add":
                String addDepartmentName = request.getParameter("department-name");
                departmentDAO.addDepartment(new Department(null, addDepartmentName));
                break;
            case "update":
                Long updateDepartmentId = Long.parseLong(request.getParameter("department-id"));
                String updateDepartmentName = request.getParameter("department-name");
                departmentDAO.updateDepartment(new Department(updateDepartmentId, updateDepartmentName));
                break;
        }
        response.sendRedirect(request.getContextPath() + "/departments");
    }
}
