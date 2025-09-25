package com.nvminh162.nguyenvanminh.dao;

import com.nvminh162.nguyenvanminh.model.Department;

import java.util.List;

public class DepartmentDAO extends GenericDAO<Department, Long> {
    public DepartmentDAO() {
        super(Department.class);
    }
}
