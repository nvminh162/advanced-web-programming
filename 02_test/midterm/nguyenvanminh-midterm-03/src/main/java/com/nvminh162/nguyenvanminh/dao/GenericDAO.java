package com.nvminh162.nguyenvanminh.dao;


import com.nvminh162.nguyenvanminh.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GenericDAO<T> {
    private Class<T> classT;

    public GenericDAO(Class<T> classT) {
        this.classT = classT;
    }

    public List<T> findAll() {
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.createQuery("FROM " + classT.getSimpleName(), classT).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public T findById(Long id) {
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.find(classT, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // id null -> insert
    // id !null -> update
    public void save(T t) {
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(Long id) {
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            em.getTransaction().begin();
            em.remove(em.find(classT, id));
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
