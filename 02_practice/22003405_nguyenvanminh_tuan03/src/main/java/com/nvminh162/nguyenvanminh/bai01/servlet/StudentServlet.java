package com.nvminh162.nguyenvanminh.bai01.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String pinCode = request.getParameter("pinCode");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String[] hobbies = request.getParameterValues("hobbies");
        String course = request.getParameter("course");

        // Đặt dữ liệu vào request attribute
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("dateOfBirth", dateOfBirth);
        request.setAttribute("mobile", mobile);
        request.setAttribute("email", email);
        request.setAttribute("gender", gender);
        request.setAttribute("address", address);
        request.setAttribute("city", city);
        request.setAttribute("pinCode", pinCode);
        request.setAttribute("state", state);
        request.setAttribute("country", country);
        request.setAttribute("hobbies", hobbies);
        request.setAttribute("course", course);

        // Chuyển tiếp đến StudentResult.jsp
        request.getRequestDispatcher("/bai01/StudentResult.jsp").forward(request, response);
    }
}