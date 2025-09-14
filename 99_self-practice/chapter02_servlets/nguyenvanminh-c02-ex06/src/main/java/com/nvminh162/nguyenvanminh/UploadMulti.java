package com.nvminh162.nguyenvanminh;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/upload-multi")
public class UploadMulti extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/FormUpload.jsp").forward(request, response);
    }

    public void destroy() {

    }
}