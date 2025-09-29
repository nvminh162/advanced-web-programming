package com.nvminh162.nguyenvanminh.dao.impl;

import com.nvminh162.nguyenvanminh.dao.GenericDAO;
import com.nvminh162.nguyenvanminh.util.JPAUtil;

import java.util.List;

public class GenericDAOImpl<T> implements GenericDAO<T> {
    private Class<T> classT;

    public GenericDAOImpl(Class<T> classT) {
        this.classT = classT;
    }

    @Override
    public List<T> findAll() {
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.createQuery("FROM " + classT.getSimpleName(), classT).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T findById(Long id) {
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.find(classT, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(T t) {
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            em.getTransaction().begin();
            em.remove(em.getReference(classT, id));
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
