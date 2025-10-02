package com.nvminh162.springjdbcdemo.service;

import com.nvminh162.springjdbcdemo.model.Employee;
import java.util.List;

/**
 * Service interface for Employee business logic
 */
public interface EmployeeService {
    
    List<Employee> getAllEmployees();
    
    Employee getEmployeeById(int id);
    
    void saveEmployee(Employee employee);
    
    void updateEmployee(Employee employee);
    
    void deleteEmployeeById(int id);
    
    boolean employeeExists(int id);
}