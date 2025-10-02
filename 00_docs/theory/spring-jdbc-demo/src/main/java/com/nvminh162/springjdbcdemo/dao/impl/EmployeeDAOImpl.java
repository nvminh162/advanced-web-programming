package com.nvminh162.springjdbcdemo.dao.impl;

import com.nvminh162.springjdbcdemo.dao.EmployeeDAO;
import com.nvminh162.springjdbcdemo.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setRole(rs.getString("role"));
            return employee;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        List<Employee> employees = jdbcTemplate.query(sql, new EmployeeRowMapper(), id);
        return employees.isEmpty() ? null : employees.get(0);
    }

    @Override
    public void saveEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, role) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getRole());
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, role = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getId());
    }

    @Override
    public void deleteEmployeeById(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}