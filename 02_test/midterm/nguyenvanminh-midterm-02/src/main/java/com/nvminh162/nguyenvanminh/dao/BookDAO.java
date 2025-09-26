package com.nvminh162.nguyenvanminh.dao;

import com.nvminh162.nguyenvanminh.model.Book;
import com.nvminh162.nguyenvanminh.util.JPAUtil;

import java.util.List;
import java.util.UUID;

public class BookDAO extends GenericDAO<Book, UUID> {
    public BookDAO() {
        super(Book.class);
    }

    @Override
    public List<Book> findAll() {
        String jpql = """
                SELECT e
                FROM Book e
                WHERE e.quantity > 0
                """;
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.createQuery(jpql, Book.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> findByName(String name) {
        String jpql = """
                SELECT e
                FROM Book e
                WHERE e.name LIKE :name
                """;
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.createQuery(jpql, Book.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
