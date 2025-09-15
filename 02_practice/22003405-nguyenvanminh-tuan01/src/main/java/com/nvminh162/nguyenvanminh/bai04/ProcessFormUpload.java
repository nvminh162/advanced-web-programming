package com.nvminh162.nguyenvanminh.bai04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/process-form-upload")
@MultipartConfig
public class ProcessFormUpload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String facebook = request.getParameter("facebook");
        String bio = request.getParameter("bio");

        // Truyền dữ liệu sang JSP
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("password", password);
        request.setAttribute("facebook", facebook);
        request.setAttribute("bio", bio);

        // Chuyển tiếp request đến ProcessFormUpload.jsp
        request.getRequestDispatcher("/bai04/ProcessFormUpload.jsp").forward(request, response);
    }
}
