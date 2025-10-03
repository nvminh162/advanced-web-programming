package com.nvminh162.nguyenvanminh.dao;

import java.util.List;
import java.util.UUID;

import com.nvminh162.nguyenvanminh.model.Department;

public interface DepartmentDAO {
    List<Department> findAll();

    Department findById(UUID id);

    void save(Department department);

    void update(Department department);

    void delete(UUID id);
}
