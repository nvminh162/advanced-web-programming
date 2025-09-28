package com.nvminh162.nguyenvanminhmidterm04.dao;


import com.nvminh162.nguyenvanminhmidterm04.model.Account;
import com.nvminh162.nguyenvanminhmidterm04.util.JPAUtil;

import java.util.List;

public class AccountDAO {
    public void save(Account account) {
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            em.getTransaction().begin();
            em.merge(account);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll() {
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.createQuery("SELECT a FROM Account a", Account.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAmountByInRange(double min, double max) {
        String jpql = """
                SELECT a
                FROM Account a
                WHERE a.amount BETWEEN :min AND :max
                """;
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.createQuery(jpql, Account.class)
                    .setParameter("min", min)
                    .setParameter("max", max)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAmountByInRangeUnlimit(double min, double max) {
        String jpql = """
                SELECT a
                FROM Account a
                WHERE a.amount BETWEEN :min AND :max
                """;
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.createQuery(jpql, Account.class)
                    .setParameter("min", min)
                    .setParameter("max", max)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findByAddress(String address) {
        String jpql = """
                SELECT a
                FROM Account a
                WHERE a.ownerAddress LIKE :adress
                """;
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.createQuery(jpql, Account.class)
                    .setParameter("adress", "%" + address + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
