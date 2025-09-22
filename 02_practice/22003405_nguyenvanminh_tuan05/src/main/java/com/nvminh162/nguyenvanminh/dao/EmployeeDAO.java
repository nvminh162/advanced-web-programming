package com.nvminh162.nguyenvanminh.dao;

import com.nvminh162.nguyenvanminh.model.Department;
import com.nvminh162.nguyenvanminh.model.Employee;
import com.nvminh162.nguyenvanminh.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private final DBUtil dbUtil;

    public EmployeeDAO(DataSource dataSource) {
        this.dbUtil = new DBUtil(dataSource);
    }

    public List<Employee> findEmployeesBelongToDepartment(Long deptId) {
        List<Employee> employees = new ArrayList<>();
        String sql = """
                SELECT e.id, e.name, e.salary, d.id AS department_id, d.name AS department_name
                FROM employees e
                INNER JOIN departments d ON e.department_id = d.id
                WHERE d.id = ?
                ORDER BY e.name
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement psmt = connection.prepareStatement(sql)
        ) {
            psmt.setLong(1, deptId);
            try (ResultSet rs = psmt.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("id");
                    String name = rs.getString("name");
                    double salary = rs.getDouble("salary");
                    Long departmentId = rs.getLong("department_id");
                    String departmentName = rs.getString("department_name");
                    employees.add(new Employee(id, name, salary, new Department(departmentId, departmentName)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<Employee> findEmployeesBelongToDepartmentWithName(Long deptId, String employeeName) {
        List<Employee> employees = new ArrayList<>();
        String sql = """
                SELECT e.id, e.name, e.salary, d.id AS department_id, d.name AS department_name
                FROM employees e
                INNER JOIN departments d ON e.department_id = d.id
                WHERE d.id = ? AND e.name LIKE ?
                ORDER BY e.name
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement psmt = connection.prepareStatement(sql)
        ) {
            psmt.setLong(1, deptId);
            psmt.setString(2, "%" + employeeName + "%");
            try (ResultSet rs = psmt.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("id");
                    String name = rs.getString("name");
                    double salary = rs.getDouble("salary");
                    Long departmentId = rs.getLong("department_id");
                    String departmentName = rs.getString("department_name");
                    employees.add(new Employee(id, name, salary, new Department(departmentId, departmentName)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void updateEmployee(Employee employee) {
        String sql = """
                UPDATE employees SET name = ?, salary = ?, department_id = ?
                WHERE id = ?
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement psmt = connection.prepareStatement(sql)
        ) {
            psmt.setString(1, employee.getName());
            psmt.setDouble(2, employee.getSalary());
            psmt.setLong(3, employee.getDepartment().getId());
            psmt.setLong(4, employee.getId());
            psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee findById(Long id) {
        Employee employee = null;
        String sql = """
                SELECT e.id, e.name, e.salary, d.id AS department_id, d.name AS department_name
                FROM employees e
                INNER JOIN departments d ON e.department_id = d.id
                WHERE e.id = ?
                """;
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement psmt = connection.prepareStatement(sql)
        ) {
            psmt.setLong(1, id);
            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    double salary = rs.getDouble("salary");
                    Long departmentId = rs.getLong("department_id");
                    String departmentName = rs.getString("department_name");
                    employee = new Employee(id, name, salary, new Department(departmentId, departmentName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement psmt = connection.prepareStatement(sql)
        ) {
            psmt.setLong(1, id);
            psmt.executeUpdate();
        }
    }

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, salary, department_id) VALUES (?, ?, ?)";
        try (Connection connection = dbUtil.getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql)
        ) {
            psmt.setString(1, employee.getName());
            psmt.setDouble(2, employee.getSalary());
            psmt.setLong(3, employee.getDepartment().getId());
            psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

