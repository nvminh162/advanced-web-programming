package com.nvminh162.nguyenvanminh.dao;

import com.nvminh162.nguyenvanminh.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GenericDAO<T, ID> {
    private Class<T> classT;

    public GenericDAO(Class<T> classT) {
        this.classT = classT;
    }

    public List<T> findAll() {
        try (EntityManager em = JPAUtil.getEmf().createEntityManager()) {
            return em.createQuery("from " + classT.getSimpleName(), classT).getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public T findById(ID id) {
        try (EntityManager em = JPAUtil.getEmf().createEntityManager()) {
            return em.find(classT, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // id null => insert
    // id not null => update
    public void save(T entity) {
        try (EntityManager em = JPAUtil.getEmf().createEntityManager()) {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById(ID id) {
        try (EntityManager em = JPAUtil.getEmf().createEntityManager()) {
            em.getTransaction().begin();
            T entity = em.find(classT, id);
            if (entity != null) em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
