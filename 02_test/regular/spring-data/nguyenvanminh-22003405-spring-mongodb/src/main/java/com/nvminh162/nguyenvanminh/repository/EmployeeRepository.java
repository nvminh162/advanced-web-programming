package com.nvminh162.nguyenvanminh.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.nvminh162.nguyenvanminh.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByName(String name);

    @Query("{'name': {$regex: ?0, $options: 'i'}}")
    List<Employee> findByNameContainingIgnoreCase(String keyword);

    Employee findByEmail(String email);

    List<Employee> findByStatus(int status);

    List<Employee> findByAge(int age);

    List<Employee> findByAgeBetween(int minAge, int maxAge);

    List<Employee> findBySalaryGreaterThan(double salary);

    @Query("{'salary': {$gte: ?0, $lte: ?1}}")
    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);

    List<Employee> findByDepartment_Id(String departmentId);
}
