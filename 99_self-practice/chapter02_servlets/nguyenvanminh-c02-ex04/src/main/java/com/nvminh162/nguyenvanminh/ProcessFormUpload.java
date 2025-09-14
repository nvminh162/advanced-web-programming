package com.nvminh162.nguyenvanminh;

import java.io.*;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/process-form-upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,  //  1MB
        maxFileSize = 1024 * 1024 * 10,   // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 15MB
)
public class ProcessFormUpload extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/form.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String[] hobbies = request.getParameterValues("hobbies");
        String country = request.getParameter("country");
        String birthdate = request.getParameter("birthdate");

        Part filePart = request.getPart("profile");
        String fileName = filePart.getSubmittedFileName();
        // Lưu vào thư mục uploads ở root của project
        String webAppPath = getServletContext().getRealPath("");
        File webAppDir = new File(webAppPath);
        // Đi ngược từ target/nguyenvanminh-1.0-SNAPSHOT về root project (2 cấp)
        String projectRoot = webAppDir.getParentFile().getParent();
        String uploadPath = projectRoot + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        // save file to uploads folder
        filePart.write(uploadPath + File.separator + fileName);
        System.out.println("File uploaded to: " + uploadPath + File.separator + fileName);

        response.setContentType("text/html");
        response.getWriter().println("Name: " + name + "<br>");
        response.getWriter().println("Password: " + password + "<br>");
        response.getWriter().println("Gender: " + gender + "<br>");
        response.getWriter().println("Hobbies: " + Arrays.toString(hobbies) + "<br>");
        response.getWriter().println("Country: " + country + "<br>");
        response.getWriter().println("Birthdate: " + birthdate + "<br>");
        response.getWriter().println("File name: " + fileName + "<br>");
        response.getWriter().println("File path: " + uploadPath + File.separator + fileName + "<br>");
    }

    public void destroy() {

    }
}