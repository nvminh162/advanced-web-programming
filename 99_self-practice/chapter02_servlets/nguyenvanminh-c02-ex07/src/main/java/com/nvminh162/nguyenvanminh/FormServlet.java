package com.nvminh162.nguyenvanminh;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,  //  1MB
        maxFileSize = 1024 * 1024 * 10,   // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 15MB
)
public class FormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/Form.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        Part filePart = request.getPart("portraitPhoto");
        String fileName = filePart.getSubmittedFileName();

        System.out.println( "firstName: " + firstName );
        System.out.println( "lastName: " + lastName );
        System.out.println( "fileName: " + fileName );
        request.setAttribute("success", "Submitted successfully!");
        request.getRequestDispatcher("/Form.jsp").forward(request, response);
    }

    public void destroy() {
    }
}