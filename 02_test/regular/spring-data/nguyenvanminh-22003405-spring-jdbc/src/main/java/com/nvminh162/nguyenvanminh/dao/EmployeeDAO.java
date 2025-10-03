package com.nvminh162.nguyenvanminh.dao;

import java.util.List;
import java.util.UUID;

import com.nvminh162.nguyenvanminh.model.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(UUID id);

    void save(Employee employee);

    void update(Employee employee);

    void delete(UUID id);
}
