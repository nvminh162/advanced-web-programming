package com.nvminh162.nguyenvanminh.dao.impl;

import com.nvminh162.nguyenvanminh.dao.QuanLyThuocDAO;
import com.nvminh162.nguyenvanminh.model.Thuoc;
import com.nvminh162.nguyenvanminh.util.JPAUtil;

import java.util.List;

public class QuanLyThuocDAOImpl extends GenericDAOImpl<Thuoc> implements QuanLyThuocDAO {
    public QuanLyThuocDAOImpl() {
        super(Thuoc.class);
    }

    @Override
    public List<Thuoc> findAllByLoaiThuoc(Long maLoai) {
        String jpql = """
                SELECT e
                FROM Thuoc e
                WHERE e.loaiThuoc.maLoai = :maLoai
                """;
        try (var em = JPAUtil.getEmf().createEntityManager()) {
            return em.createQuery(jpql, Thuoc.class)
                    .setParameter("maLoai", maLoai)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
