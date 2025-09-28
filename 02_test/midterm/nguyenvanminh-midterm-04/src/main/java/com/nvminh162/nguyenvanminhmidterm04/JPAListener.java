package com.nvminh162.nguyenvanminhmidterm04;

import com.nvminh162.nguyenvanminhmidterm04.util.JPAUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class JPAListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) { JPAUtil.init(); }

    @Override
    public void contextDestroyed(ServletContextEvent sce) { JPAUtil.close(); }
}
