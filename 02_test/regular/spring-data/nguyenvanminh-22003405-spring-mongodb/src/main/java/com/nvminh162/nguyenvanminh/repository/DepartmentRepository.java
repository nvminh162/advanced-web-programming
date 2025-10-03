package com.nvminh162.nguyenvanminh.repository;

import com.nvminh162.nguyenvanminh.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {}
