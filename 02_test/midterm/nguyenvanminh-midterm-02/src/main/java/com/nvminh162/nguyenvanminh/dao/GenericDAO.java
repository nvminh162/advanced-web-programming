package com.nvminh162.nguyenvanminh.dao;

import com.nvminh162.nguyenvanminh.util.JPAUtil;
import jakarta.persistence.OptimisticLockException;

import java.util.List;

public class GenericDAO<T, ID> {
    private Class<T> classT;

    public GenericDAO(Class<T> classT) {
        this.classT = classT;
    }

    public List<T> findAll() {

        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.createQuery("FROM " + classT.getSimpleName(), classT).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public T findById(ID id) {
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.find(classT, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // id null => insert
    // id not null => update
    public void save(T entity) {
        var em = JPAUtil.getEmf().createEntityManager();
        var transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(entity);
            transaction.commit();
        } catch (OptimisticLockException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Re-throw to allow retry logic in caller
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error saving entity", e);
        } finally {
            em.close();
        }
    }

    public void deleteById(ID id) {
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            em.getTransaction().begin();
            T entity = em.find(classT, id);
            if (entity != null) em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}