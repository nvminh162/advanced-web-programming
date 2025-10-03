package com.nvminh162.nguyenvanminh.service;

import java.util.List;

import com.nvminh162.nguyenvanminh.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    void createEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(String id);

    List<Employee> getEmployeesByDepartmentId(String departmentId);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesByAge(int age);

    List<Employee> getEmployeesBySalaryRange(double from, double to);
}