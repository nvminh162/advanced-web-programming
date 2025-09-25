package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.dao.DepartmentDAO;
import com.nvminh162.nguyenvanminh.model.Department;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/departments")
public class DepartmentServlet extends HttpServlet {
    private DepartmentDAO departmentDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        departmentDAO = new DepartmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";
        String id = request.getParameter("id");

        switch (action) {
            case "list" -> {
                request.setAttribute("departments", departmentDAO.findAll());
                request.getRequestDispatcher("/departments.jsp").forward(request, response);
            }
            case "create" -> {
                request.getRequestDispatcher("/department-form.jsp").forward(request, response);
            }
            case "update" -> {
                request.setAttribute("department", departmentDAO.findById(Long.parseLong(id)));
                request.getRequestDispatcher("/department-form.jsp").forward(request, response);
            }
            default -> response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        if (action == null) return;
        switch (action) {
            case "save" -> {
                departmentDAO.save(Department.builder()
                        .id(id != null ? Long.parseLong(id) : null)
                        .name(name)
                        .build());
            }
            case "delete" -> {
                departmentDAO.deleteById(Long.parseLong(id));
            }
        }
        response.sendRedirect("departments");
    }
}
