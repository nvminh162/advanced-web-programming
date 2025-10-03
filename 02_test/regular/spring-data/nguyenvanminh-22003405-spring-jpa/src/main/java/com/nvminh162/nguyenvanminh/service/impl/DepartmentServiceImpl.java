package com.nvminh162.nguyenvanminh.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvminh162.nguyenvanminh.dao.DepartmentDAO;
import com.nvminh162.nguyenvanminh.model.Department;
import com.nvminh162.nguyenvanminh.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }

    @Override
    public Department getDepartmentById(UUID id) {
        return departmentDAO.findById(id);
    }

    @Override
    public void createDepartment(Department department) {
        departmentDAO.save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDAO.update(department);
    }

    @Override
    public void deleteDepartment(UUID id) {
        departmentDAO.delete(id);
    }
}
