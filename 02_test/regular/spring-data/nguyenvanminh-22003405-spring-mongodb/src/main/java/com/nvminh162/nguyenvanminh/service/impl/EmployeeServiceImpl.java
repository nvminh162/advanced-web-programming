package com.nvminh162.nguyenvanminh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nvminh162.nguyenvanminh.model.Employee;
import com.nvminh162.nguyenvanminh.repository.EmployeeRepository;
import com.nvminh162.nguyenvanminh.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (employee.getId() == null || !employeeRepository.existsById(employee.getId())) {
            throw new RuntimeException("Employee not found with id: " + employee.getId());
        }
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(String departmentId) {
        if (departmentId == null || departmentId.trim().isEmpty()) {
            return List.of();
        }
        return employeeRepository.findByDepartment_Id(departmentId.trim());
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        // Sử dụng search không phân biệt hoa thường và tìm theo keyword
        if (name == null || name.trim().isEmpty()) {
            return List.of();
        }
        return employeeRepository.findByNameContainingIgnoreCase(name.trim());
    }

    @Override
    public List<Employee> getEmployeesByAge(int age) {
        // Tìm theo tuổi chính xác
        return employeeRepository.findByAge(age);
    }

    @Override
    public List<Employee> getEmployeesBySalaryRange(double from, double to) {
        // Xử lý trường hợp chỉ có một trong hai giá trị
        if (from > 0 && to > 0) {
            // Cả hai đều có giá trị
            return employeeRepository.findBySalaryBetween(from, to);
        } else if (from > 0) {
            // Chỉ có giá trị from
            return employeeRepository.findBySalaryGreaterThan(from);
        } else if (to > 0) {
            // Chỉ có giá trị to - tìm tất cả salary <= to
            return employeeRepository.findBySalaryBetween(0, to);
        }
        // Không có giá trị nào - trả về danh sách rỗng
        return List.of();
    }
}
