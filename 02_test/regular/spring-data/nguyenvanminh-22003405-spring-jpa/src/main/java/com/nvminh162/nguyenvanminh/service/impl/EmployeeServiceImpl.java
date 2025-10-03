package com.nvminh162.nguyenvanminh.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvminh162.nguyenvanminh.dao.EmployeeDAO;
import com.nvminh162.nguyenvanminh.model.Employee;
import com.nvminh162.nguyenvanminh.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        return employeeDAO.findById(id);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void deleteEmployee(UUID id) {
        employeeDAO.delete(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(UUID departmentId) {
        return employeeDAO.findByDepartmentId(departmentId);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeDAO.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByAge(int age) {
        return employeeDAO.findByAge(age);
    }

    @Override
    public List<Employee> getEmployeesBySalaryRange(double from, double to) {
        return employeeDAO.findByInSalary(from, to);
    }
}
