package com.nvminh162.nguyenvanminh.dao;

import com.nvminh162.nguyenvanminh.model.Order;

import java.util.UUID;

public class OrderDAO extends GenericDAO<Order, UUID> {
    public OrderDAO() {
        super(Order.class);
    }
}
