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
        try (var em = JPAUtil.getEmf().createEntityManager();) {
            return em.createQuery(jpql, Employee.class)
                    .setParameter("id", id)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> findByName(String name) {
        String jpql = """
                SELECT e FROM Employee e WHERE e.name LIKE :name
                """;
        try (var em = JPAUtil.getEmf().createEntityManager();) {
            return em.createQuery(jpql, Employee.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public List<Employee> findByNameBelongDepartment(String name, Long departmentId) {
        String jpql = """
                SELECT e
                FROM Employee e
                WHERE e.name LIKE :name
                AND e.department.id = :departmentId
                """;
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.createQuery(jpql, Employee.class)
                    .setParameter("name", "%" + name + "%")
                    .setParameter("departmentId", departmentId)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
