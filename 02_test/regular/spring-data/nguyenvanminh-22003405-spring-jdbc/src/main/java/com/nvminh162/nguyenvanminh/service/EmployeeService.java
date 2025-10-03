package com.nvminh162.nguyenvanminh.service;

import java.util.List;
import java.util.UUID;

import com.nvminh162.nguyenvanminh.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(UUID id);

    void createEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(UUID id);
}
