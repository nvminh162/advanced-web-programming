package com.nvminh162.nguyenvanminh.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Document(collection = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    String id;

    @Field(name = "name")
    String name;
    
    @Field(name = "email")
    String email;
    
    @Field(name = "age")
    int age;
    
    @Field(name = "salary")
    double salary;
    
    @Field(name = "status")
    int status;
    
    @DBRef
    Department department;
}
