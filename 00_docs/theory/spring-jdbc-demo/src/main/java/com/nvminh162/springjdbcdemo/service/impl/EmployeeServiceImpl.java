package com.nvminh162.springjdbcdemo.service.impl;

import com.nvminh162.springjdbcdemo.dao.EmployeeDAO;
import com.nvminh162.springjdbcdemo.model.Employee;
import com.nvminh162.springjdbcdemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        if (employee.getName() == null || employee.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be null or empty");
        }
        if (employee.getRole() == null || employee.getRole().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee role cannot be null or empty");
        }
        employeeDAO.saveEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (!employeeExists(employee.getId())) {
            throw new RuntimeException("Employee with id " + employee.getId() + " not found");
        }
        if (employee.getName() == null || employee.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be null or empty");
        }
        if (employee.getRole() == null || employee.getRole().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee role cannot be null or empty");
        }
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        if (!employeeExists(id)) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        employeeDAO.deleteEmployeeById(id);
    }

    @Override
    public boolean employeeExists(int id) {
        return employeeDAO.getEmployeeById(id) != null;
    }
}