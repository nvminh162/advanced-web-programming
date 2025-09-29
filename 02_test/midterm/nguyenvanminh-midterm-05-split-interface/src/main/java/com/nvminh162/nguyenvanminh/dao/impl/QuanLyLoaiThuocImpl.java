package com.nvminh162.nguyenvanminh.dao.impl;

import com.nvminh162.nguyenvanminh.dao.QuanLyLoaiThuocDAO;
import com.nvminh162.nguyenvanminh.model.LoaiThuoc;

public class QuanLyLoaiThuocImpl extends GenericDAOImpl<LoaiThuoc> implements QuanLyLoaiThuocDAO {
    public QuanLyLoaiThuocImpl() {
        super(LoaiThuoc.class);
    }
}
