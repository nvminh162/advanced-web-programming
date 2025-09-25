package com.nvminh162.nguyenvanminh.dao;

import com.nvminh162.nguyenvanminh.model.Department;
import com.nvminh162.nguyenvanminh.util.JPAUtil;

import java.util.List;

public class DepartmentDAO extends GenericDAO<Department, Long> {
    public DepartmentDAO() {
        super(Department.class);
    }

    public List<Department> findByName(String name) {
        String jpql = """
                SELECT d FROM Department d WHERE d.name LIKE :name
                """;
        try (var em = JPAUtil.getEmf().createEntityManager();) {
            return em.createQuery(jpql, Department.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
