package com.nvminh162.nguyenvanminh.dao.impl;

import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nvminh162.nguyenvanminh.dao.DepartmentDAO;
import com.nvminh162.nguyenvanminh.model.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
    private final JdbcTemplate jdbcTemplate;

    public DepartmentDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Department> findAll() {
        String sql = """
                SELECT * FROM departments
                """;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Department.class));
    }

    @Override
    public Department findById(UUID id) {
        String sql = "SELECT * FROM departments WHERE id = ?";
        List<Department> departments = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Department.class), id.toString());
        return departments.isEmpty() ? null : departments.get(0);
    }

    @Override
    public void save(Department department) {
        String sql = "INSERT INTO departments (id, name) VALUES (?, ?)";
        jdbcTemplate.update(sql,
                UUID.randomUUID().toString(),
                department.getName());
    }

    @Override
    public void update(Department department) {
        String sql = "UPDATE departments SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                department.getName(),
                department.getId().toString());
    }

    @Override
    public void delete(UUID id) {
        String sql = "DELETE FROM departments WHERE id = ?";
        jdbcTemplate.update(sql, id.toString());
    }

}
