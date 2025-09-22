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
        String action = request.getParameter("action");
        if (action == null) {
            Long departmentId = Long.parseLong(request.getParameter("department-id"));
            List<Employee> employees = employeeDAO.findEmployeesBelongToDepartment(departmentId);
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("/employees.jsp").forward(request, response);
            return;
        }

        switch (action) {
            case "update":
                Long updateEmployeeId = Long.parseLong(request.getParameter("employee-id"));
                request.setAttribute("employee", employeeDAO.findById(updateEmployeeId));
                request.setAttribute("departments", departmentDAO.findAll());
                request.getRequestDispatcher("/employee-update.jsp").forward(request, response);
                return;
            case "add":
                request.setAttribute("departments", departmentDAO.findAll());
                request.getRequestDispatcher("/employee-add.jsp").forward(request, response);
                return;
            case "search":
                Long searchDepartmentId = Long.parseLong(request.getParameter("department-id"));
                String searchEmployeeName = request.getParameter("employee-name");
                List<Employee> searchEmployees = employeeDAO.findEmployeesBelongToDepartmentWithName(searchDepartmentId, searchEmployeeName);
                request.setAttribute("employees", searchEmployees);
                request.getRequestDispatcher("/employees.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) return;
        switch (action) {
            case "delete":
                Long deleteEmployeeId = Long.parseLong(request.getParameter("employee-id"));
                long deleteEmployeeDepartmentId = Long.parseLong(request.getParameter("employee-department-id"));
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
                String addEmployeeDepartmentId = request.getParameter("employee-department-id");
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
