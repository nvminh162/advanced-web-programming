package com.nvminh162.nguyenvanminh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nvminh162.nguyenvanminh.model.Department;
import com.nvminh162.nguyenvanminh.repository.DepartmentRepository;
import com.nvminh162.nguyenvanminh.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
    }

    @Override
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        if (department.getId() == null || !departmentRepository.existsById(department.getId())) {
            throw new RuntimeException("Department not found with id: " + department.getId());
        }
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(String id) {
        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("Department not found with id: " + id);
        }
        departmentRepository.deleteById(id);
    }
}

