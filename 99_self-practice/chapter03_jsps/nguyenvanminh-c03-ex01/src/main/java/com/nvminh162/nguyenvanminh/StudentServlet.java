package com.nvminh162.nguyenvanminh;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("/Form.jsp");
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirthStr = request.getParameter("dob");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String pinCode = request.getParameter("pinCode");
        String state = request.getParameter("state");
        String country = request.getParameter("country");

        String examination1 = request.getParameter("exam1");
        String board1 = request.getParameter("board1");
        String percentage1 = request.getParameter("percentage1");
        String yearOfPassing1 = request.getParameter("year1");

        String examination2 = request.getParameter("exam2");
        String board2 = request.getParameter("board2");
        String percentage2 = request.getParameter("percentage2");
        String yearOfPassing2 = request.getParameter("year2");

        String[] hobbiesArray = request.getParameterValues("hobbies");
        List<String> hobbies = new ArrayList<>();
        if (hobbiesArray != null) {
            hobbies = Arrays.asList(hobbiesArray);
        }

        // Courses Applied For (checkbox values)
        String[] coursesArray = request.getParameterValues("courses");
        List<String> coursesAppliedFor = new ArrayList<>();
        if (coursesArray != null) {
            coursesAppliedFor = Arrays.asList(coursesArray);
        }

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setMobile(mobile);
        student.setGender(gender);
        student.setAddress(address);
        student.setCity(city);
        student.setPinCode(pinCode);
        student.setState(state);
        student.setCountry(country);

        if (dateOfBirthStr != null && !dateOfBirthStr.trim().isEmpty()) {
            try {
                LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);
                student.setDateOfBirth(dateOfBirth);
            } catch (Exception e) {
                // Handle date parsing error
                e.printStackTrace();
            }
        }

        student.setHobbies(hobbies);
        student.setCoursesAppliedFor(coursesAppliedFor);

        student.setExamination1(examination1);
        student.setBoard1(board1);
        student.setPercentage1(percentage1);
        student.setYearOfPassing1(yearOfPassing1);

        student.setExamination2(examination2);
        student.setBoard2(board2);
        student.setPercentage2(percentage2);
        student.setYearOfPassing2(yearOfPassing2);

        System.out.println("Student created: " + student);
        request.setAttribute("student", student);

        // Forward to result page
        RequestDispatcher rd = request.getRequestDispatcher("/StudentResult.jsp");
        rd.forward(request, response);
    }

    public void destroy() {
    }
}