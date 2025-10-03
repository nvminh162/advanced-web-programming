package com.nvminh162.nguyenvanminh.service;

import java.util.List;

import com.nvminh162.nguyenvanminh.model.Department;

public interface DepartmentService {
    List<Department> getAllDepartments();

    Department getDepartmentById(String id);

    void createDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(String id);
}