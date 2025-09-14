package com.nvminh162.nguyenvanminh;

import java.io.*;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,  //  1MB
        maxFileSize = 1024 * 1024 * 10,   // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class FormServlet extends HttpServlet {

    private UserDAO userDAO;
    private String uploadPath;

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO();
        // Tạo thư mục uploads trong webapp
        uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/Form.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Đọc dữ liệu của form: dữ liệu text + dữ liệu file
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Part filePart = request.getPart("portraitPhoto");
        String picFile = filePart.getSubmittedFileName();

        User user = new User(firstName, lastName, picFile);

        // Use DAO to insert user data
        boolean success = false;
        try {
            success = userDAO.addUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (success) {
            System.out.println("Data inserted successfully!");
            System.out.println("firstName: " + firstName);
            System.out.println("lastName: " + lastName);
            System.out.println("picFile: " + picFile);
            request.setAttribute("success", "File uploaded and data saved to database successfully!");
        } else {
            request.setAttribute("error", "Failed to save data to database!");
        }
        request.getRequestDispatcher("/Form.jsp").forward(request, response);
    }

    public void destroy() {
    }
}