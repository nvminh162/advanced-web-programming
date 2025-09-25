package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.dao.DepartmentDAO;
import com.nvminh162.nguyenvanminh.dao.EmployeeDAO;
import com.nvminh162.nguyenvanminh.model.Department;
import com.nvminh162.nguyenvanminh.model.Employee;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    private DepartmentDAO departmentDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        employeeDAO = new EmployeeDAO();
        departmentDAO = new DepartmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        String id = request.getParameter("id");
        String departmentId = request.getParameter("department-id");
        String name = request.getParameter("name");
        System.out.println(name + " ================== " + departmentId);

        request.setAttribute("departments", departmentDAO.findAll());
        if (action == null) action = "list";
        switch (action) {
            case "search" -> {
                if (departmentId.isEmpty()) {
                    request.setAttribute("employees", employeeDAO.findByName(name));
                    request.getRequestDispatcher("/employees.jsp").forward(request, response);
                } else {
                    request.setAttribute("employees", employeeDAO.findByNameBelongDepartment(name, Long.parseLong(departmentId)));
                    request.getRequestDispatcher("/employees.jsp").forward(request, response);
                }
            }
            case "list_belongDeptId" -> {
                request.setAttribute("employees", employeeDAO.findAllBelongDepartment(Long.parseLong(departmentId)));
                request.getRequestDispatcher("/employees.jsp").forward(request, response);
            }
            case "list" -> {
                request.setAttribute("employees", employeeDAO.findAll());
                request.getRequestDispatcher("/employees.jsp").forward(request, response);
            }
            case "create" -> {
                request.getRequestDispatcher("/employee-form.jsp").forward(request, response);
            }
            case "update" -> {
                request.setAttribute("employee", employeeDAO.findById(Long.parseLong(id)));
                request.getRequestDispatcher("/employee-form.jsp").forward(request, response);
            }
            default -> response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String salary = request.getParameter("salary");
        String departmentId = request.getParameter("department-id");

        if (action == null) return;
        switch (action) {
            case "save" -> {
                employeeDAO.save(Employee.builder()
                        .id(id != null ? Long.parseLong(id) : null)
                        .name(name)
                        .salary(Double.parseDouble(salary))
                        .department(departmentDAO.findById(Long.parseLong(departmentId)))
                        .build());
            }
            case "delete" -> {
                employeeDAO.deleteById(Long.parseLong(id));
            }
        }
        response.sendRedirect("employees?department-id=" + departmentId);
    }
}

