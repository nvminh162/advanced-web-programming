package com.nvminh162.nguyenvanminh.dao;

import com.nvminh162.nguyenvanminh.model.Employee;
import com.nvminh162.nguyenvanminh.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EmployeeDAO extends GenericDAO<Employee, Long> {
    public EmployeeDAO() {
        super(Employee.class);
    }

    public List<Employee> findAllBelongDepartment(Long id) {
        String jpql = """
                SELECT e FROM Employee e WHERE e.department.id = :id
                """;
        try (EntityManager em = JPAUtil.getEmf().createEntityManager();) {
            return em.createQuery(jpql, Employee.class)
                    .setParameter("id", id)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
