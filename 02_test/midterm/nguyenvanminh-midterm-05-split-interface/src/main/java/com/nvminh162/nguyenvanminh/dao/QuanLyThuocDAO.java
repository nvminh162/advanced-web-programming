package com.nvminh162.nguyenvanminh.dao;

import com.nvminh162.nguyenvanminh.model.Thuoc;

import java.util.List;

public interface QuanLyThuocDAO extends GenericDAO<Thuoc> {
    List<Thuoc> findAllByLoaiThuoc(Long id);
}
