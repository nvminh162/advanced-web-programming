package com.nvminh162.nguyenvanminh.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nvminh162.nguyenvanminh.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    List<Employee> findByDepartmentId(UUID departmentId);
    
    List<Employee> findByStatus(int status);
    
    List<Employee> findByName(String name);
    
    List<Employee> findByAge(int age);
    
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmail(@Param("email") String email);
    
    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId AND e.status = :status")
    List<Employee> findByDepartmentIdAndStatus(@Param("departmentId") UUID departmentId, @Param("status") int status);
    
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :from AND :to")
    List<Employee> findBySalaryBetween(@Param("from") double from, @Param("to") double to);
}