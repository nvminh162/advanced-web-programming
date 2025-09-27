package com.nvminh162.nguyenvanminh.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public class JPAUtil {
    @Getter
    private static EntityManagerFactory emf;

    public static void init() {
        if (emf == null) emf = Persistence.createEntityManagerFactory("nguyenvanminh_mariadb");
    }

    public static void close() {
        if (emf != null && emf.isOpen()) emf.close();
    }
}
