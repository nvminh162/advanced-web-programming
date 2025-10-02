package com.nvminh162.springjdbcdemo.dao;

import com.nvminh162.springjdbcdemo.model.Employee;
import java.util.List;

/**
 * DAO interface for Employee operations
 */
public interface EmployeeDAO {
    
    /**
     * Lấy tất cả employees
     */
    List<Employee> getAllEmployees();
    
    /**
     * Lấy employee theo id
     */
    Employee getEmployeeById(int id);
    
    /**
     * Thêm employee mới
     */
    void saveEmployee(Employee employee);
    
    /**
     * Cập nhật employee
     */
    void updateEmployee(Employee employee);
    
    /**
     * Xóa employee theo id
     */
    void deleteEmployeeById(int id);
}