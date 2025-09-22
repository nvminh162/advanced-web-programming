package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.dao.DepartmentDAO;
import com.nvminh162.nguyenvanminh.dao.EmployeeDAO;
import com.nvminh162.nguyenvanminh.model.Department;
import com.nvminh162.nguyenvanminh.model.Employee;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/employee", "/employees"})
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    private DepartmentDAO departmentDAO;
    @Resource(name = "jdbc/www_c03_ex05")
    private DataSource dataSource;

    @Override
    public void init() {
        employeeDAO = new EmployeeDAO(dataSource);
        departmentDAO = new DepartmentDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Update Department
        String employeeId = request.getParameter("employee-id");
        if (employeeId != null) {
            request.setAttribute("employee", employeeDAO.findById(Long.parseLong(employeeId)));
            request.getRequestDispatcher("/employee-update.jsp").forward(request, response);
            return;
        }
        // Find List Employees belong to Department (fillAllBeLongDepartment)
        Long departmentId = Long.parseLong(request.getParameter("department-id"));
        // Find List Employees belong to Department With Employee name (fillAllBeLongDepartmentWithName)
        String employeeName = request.getParameter("employee-name");
        List<Employee> employees;
        if (employeeName != null) {
            employees = employeeDAO.findEmployeesBelongToDepartmentWithName(departmentId, employeeName);
        } else {
            employees = employeeDAO.findEmployeesBelongToDepartment(departmentId);
        }
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/employees.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) return;
        switch (action) {
            case "delete":
                Long deleteEmployeeId = Long.parseLong(request.getParameter("employee-id"));
                Long deleteEmployeeDepartmentId = Long.parseLong(request.getParameter("employee-department-id"));
                try {
                    employeeDAO.deleteById(deleteEmployeeId);
                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
                }
                response.sendRedirect(request.getContextPath() + "/employees?department-id=" + deleteEmployeeDepartmentId);
                break;
            case "add":
                String addEmployeeName = request.getParameter("employee-name");
                double addEmployeeSalaly = Double.parseDouble(request.getParameter("employee-salary"));
                String addEmployeeDepartmentId = request.getParameter("employee-deparment-id");
                Department addDepartment = departmentDAO.findById(Long.parseLong(addEmployeeDepartmentId));
                employeeDAO.addEmployee(new Employee(null, addEmployeeName, addEmployeeSalaly, addDepartment));
                response.sendRedirect(request.getContextPath() + "/employees?department-id=" + addEmployeeDepartmentId);
                break;
            case "update":
                Long updateEmployeeId = Long.parseLong(request.getParameter("employee-id"));
                String updateEmployeeName = request.getParameter("employee-name");
                double updateEmployeeSalary = Double.parseDouble(request.getParameter("employee-salary"));
                String updateEmployeeDepartmentId = request.getParameter("employee-department-id");
                Department updateDepartment = departmentDAO.findById(Long.parseLong(updateEmployeeDepartmentId));
                employeeDAO.updateEmployee(new Employee(updateEmployeeId, updateEmployeeName, updateEmployeeSalary, updateDepartment));
                response.sendRedirect(request.getContextPath() + "/employee?department-id=" + updateEmployeeDepartmentId);
                break;
        }
    }
}
