package com.nvminh162.nguyenvanminh.dao;

import java.util.List;

public interface GenericDAO<T> {
    List<T> findAll();

    T findById(Long id);

    // id save
    // !id update
    void save(T t);

    void deleteById(Long id);
}
