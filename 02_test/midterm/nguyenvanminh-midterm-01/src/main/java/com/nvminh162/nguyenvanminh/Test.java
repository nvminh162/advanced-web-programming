package com.nvminh162.nguyenvanminh;

import com.nvminh162.nguyenvanminh.dao.DepartmentDAO;
import com.nvminh162.nguyenvanminh.dao.EmployeeDAO;
import com.nvminh162.nguyenvanminh.util.JPAUtil;

public class Test {
    public static void main(String[] args) {
        JPAUtil.init();

        DepartmentDAO departmentDAO = new DepartmentDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
//        System.out.println(employeeDAO.findAll());
//        System.out.println(departmentDAO.findAll());
//        System.out.println(employeeDAO.findAllBelongDepartment(1L).size());
//        System.out.println(departmentDAO.findByName("sự"));
//        System.out.println(employeeDAO.findByName("An").size());
//        System.out.println(employeeDAO.findByNameBelongDepartment("Nguyễn", 1L));
        JPAUtil.close();
    }
}
