package com.nvminh162.springjdbcdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Employee entity class representing employee table
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String role;
    
    // Constructor không có id (cho insert)
    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
}