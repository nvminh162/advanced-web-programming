package com.nvminh162.nguyenvanminh.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import com.nvminh162.nguyenvanminh.dao.EmployeeDAO;
import com.nvminh162.nguyenvanminh.model.Department;
import com.nvminh162.nguyenvanminh.model.Employee;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static RowMapper<Employee> rowMapper = new RowMapper<Employee>() {
        @Override
        public Employee mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
            return Employee.builder()
                    .id(UUID.fromString(rs.getString("id")))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .salary(rs.getDouble("salary"))
                    .department(
                            Department.builder()
                                    .id(UUID.fromString(rs.getString("department_id")))
                                    .name(rs.getString("department_name"))
                                    .build())
                    .build();
        }
    };

    @Override
    public List<Employee> findAll() {
        String sql = """
                SELECT e.id, e.name, e.age, e.salary, e.department_id, d.name AS department_name
                FROM employees e
                JOIN departments d ON e.department_id = d.id;
                """;
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Employee findById(UUID id) {
        String sql = """
                SELECT e.id, e.name, e.age, e.salary, e.department_id, d.name AS department_name
                FROM employees e
                JOIN departments d ON e.department_id = d.id
                WHERE e.id = ?
                """;
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper, id.toString());
        return employees.isEmpty() ? null : employees.get(0);
    }

    @Override
    public void save(Employee employee) {
        String sql = """
                INSERT INTO employees (id, name, age, salary, department_id)
                VALUES (?, ?, ?, ?, ?)
                """;
        jdbcTemplate.update(sql,
                employee.getId().toString(),
                employee.getName(),
                employee.getAge(),
                employee.getSalary(),
                employee.getDepartment().getId().toString());
    }

    @Override
    public void update(Employee employee) {
        String sql = """
                UPDATE employees
                SET name = ?, age = ?, salary = ?, department_id = ?
                WHERE id = ?
                """;
        jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getSalary(),
                employee.getDepartment().getId().toString(),
                employee.getId().toString());
    }

    @Override
    public void delete(UUID id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql, id.toString());
    }

    @Override
    public List<Employee> findByDepartmentId(UUID departmentId) {
        String sql = """
                SELECT e.id, e.name, e.age, e.salary, e.department_id, d.name AS department_name
                FROM employees e
                JOIN departments d ON e.department_id = d.id
                WHERE e.department_id = ?
                """;
        return jdbcTemplate.query(sql, rowMapper, departmentId.toString());
    }

    @Override
    public List<Employee> findByName(String name) {
        String sql = """
                SELECT e.id, e.name, e.age, e.salary, e.department_id, d.name AS department_name
                FROM employees e
                JOIN departments d ON e.department_id = d.id
                WHERE e.name LIKE ?
                """;
        return jdbcTemplate.query(sql, rowMapper, "%" + name + "%");
    }

    @Override
    public List<Employee> findByAge(int age) {
        String sql = """
                SELECT e.id, e.name, e.age, e.salary, e.department_id, d.name AS department_name
                FROM employees e
                JOIN departments d ON e.department_id = d.id
                WHERE e.age = ?
                """;
        return jdbcTemplate.query(sql, rowMapper, age);
    }

    @Override
    public List<Employee> findByInSalary(double from, double to) {
        String sql;
        Object[] params;
        
        if (from > 0 && to > 0) {
            // Tìm trong khoảng from đến to
            sql = """
                    SELECT e.id, e.name, e.age, e.salary, e.department_id, d.name AS department_name
                    FROM employees e
                    JOIN departments d ON e.department_id = d.id
                    WHERE e.salary BETWEEN ? AND ?
                    """;
            params = new Object[]{from, to};
        } else if (from > 0 && to <= 0) {
            // Tìm từ from đến vô cực
            sql = """
                    SELECT e.id, e.name, e.age, e.salary, e.department_id, d.name AS department_name
                    FROM employees e
                    JOIN departments d ON e.department_id = d.id
                    WHERE e.salary >= ?
                    """;
            params = new Object[]{from};
        } else if (from <= 0 && to > 0) {
            // Tìm từ 0 đến to
            sql = """
                    SELECT e.id, e.name, e.age, e.salary, e.department_id, d.name AS department_name
                    FROM employees e
                    JOIN departments d ON e.department_id = d.id
                    WHERE e.salary <= ?
                    """;
            params = new Object[]{to};
        } else {
            // Nếu cả hai đều <= 0, trả về danh sách rỗng
            return List.of();
        }
        
        return jdbcTemplate.query(sql, rowMapper, params);
    }
}