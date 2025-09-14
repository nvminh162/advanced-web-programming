package com.nvminh162.nguyenvanminh;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String picFile;

    public User(String firstName, String lastName, String picFile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.picFile = picFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPicFile() {
        return picFile;
    }

    public void setPicFile(String picFile) {
        this.picFile = picFile;
    }
}
