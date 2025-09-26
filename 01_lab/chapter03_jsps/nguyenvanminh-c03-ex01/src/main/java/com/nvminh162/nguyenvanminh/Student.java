package com.nvminh162.nguyenvanminh;

import java.time.LocalDate;
import java.util.List;

public class Student {
    // Primary key
    private Long id;

    // Personal Information
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String mobile;
    private String gender;

    // Address Information
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private String country;

    // Hobbies (many-to-many relationship)
    private List<String> hobbies;

    // Qualification Information - First Qualification
    private String examination1;
    private String board1;
    private String percentage1;
    private String yearOfPassing1;

    // Qualification Information - Second Qualification
    private String examination2;
    private String board2;
    private String percentage2;
    private String yearOfPassing2;

    // Courses Applied For (many-to-many relationship)
    private List<String> coursesAppliedFor;

    // Default Constructor
    public Student() {
    }

    // Constructor with essential fields
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Constructor with all parameters
    public Student(String firstName, String lastName, LocalDate dateOfBirth, String email, 
                   String mobile, String gender, String address, String city, String pinCode, 
                   String state, String country, List<String> hobbies, String examination1, 
                   String board1, String percentage1, String yearOfPassing1, String examination2, 
                   String board2, String percentage2, String yearOfPassing2, List<String> coursesAppliedFor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
        this.hobbies = hobbies;
        this.examination1 = examination1;
        this.board1 = board1;
        this.percentage1 = percentage1;
        this.yearOfPassing1 = yearOfPassing1;
        this.examination2 = examination2;
        this.board2 = board2;
        this.percentage2 = percentage2;
        this.yearOfPassing2 = yearOfPassing2;
        this.coursesAppliedFor = coursesAppliedFor;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getExamination1() {
        return examination1;
    }

    public void setExamination1(String examination1) {
        this.examination1 = examination1;
    }

    public String getBoard1() {
        return board1;
    }

    public void setBoard1(String board1) {
        this.board1 = board1;
    }

    public String getPercentage1() {
        return percentage1;
    }

    public void setPercentage1(String percentage1) {
        this.percentage1 = percentage1;
    }

    public String getYearOfPassing1() {
        return yearOfPassing1;
    }

    public void setYearOfPassing1(String yearOfPassing1) {
        this.yearOfPassing1 = yearOfPassing1;
    }

    public String getExamination2() {
        return examination2;
    }

    public void setExamination2(String examination2) {
        this.examination2 = examination2;
    }

    public String getBoard2() {
        return board2;
    }

    public void setBoard2(String board2) {
        this.board2 = board2;
    }

    public String getPercentage2() {
        return percentage2;
    }

    public void setPercentage2(String percentage2) {
        this.percentage2 = percentage2;
    }

    public String getYearOfPassing2() {
        return yearOfPassing2;
    }

    public void setYearOfPassing2(String yearOfPassing2) {
        this.yearOfPassing2 = yearOfPassing2;
    }

    public List<String> getCoursesAppliedFor() {
        return coursesAppliedFor;
    }

    public void setCoursesAppliedFor(List<String> coursesAppliedFor) {
        this.coursesAppliedFor = coursesAppliedFor;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", hobbies=" + hobbies +
                ", examination1='" + examination1 + '\'' +
                ", board1='" + board1 + '\'' +
                ", percentage1='" + percentage1 + '\'' +
                ", yearOfPassing1='" + yearOfPassing1 + '\'' +
                ", examination2='" + examination2 + '\'' +
                ", board2='" + board2 + '\'' +
                ", percentage2='" + percentage2 + '\'' +
                ", yearOfPassing2='" + yearOfPassing2 + '\'' +
                ", coursesAppliedFor=" + coursesAppliedFor +
                '}';
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
