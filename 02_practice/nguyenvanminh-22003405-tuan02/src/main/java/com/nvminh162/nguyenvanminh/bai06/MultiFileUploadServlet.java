package com.nvminh162.nguyenvanminh.bai06;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/bai06/uploadmulti")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class MultiFileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "uploads";
    
    // Allowed image file extensions
    private static final String[] ALLOWED_IMAGE_EXTENSIONS = {
        ".jpg", ".jpeg", ".png", ".gif", ".bmp", ".webp"
    };

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        req.getRequestDispatcher("/bai06/Form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Tạo thư mục uploads trong src/main/uploads
        String realPath = getServletContext().getRealPath("");
        String projectRoot = realPath.substring(0, realPath.indexOf("target"));
        String uploadPath = projectRoot + "src" + File.separator + "main" + File.separator + UPLOAD_DIR;
        
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Lấy tất cả file từ request
        for (Part part : req.getParts()) {
            String fileName = getFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                
                // Kiểm tra xem file có phải là image không
                if (isImageFile(fileName)) {
                    // Lưu file vào thư mục uploads
                    part.write(uploadPath + File.separator + fileName);
                    
                    // Log thông tin file đã upload
                    System.out.println("Image uploaded: " + fileName);
                    System.out.println("File size: " + part.getSize() + " bytes");
                } else {
                    System.out.println("File rejected (not an image): " + fileName);
                }
            }
        }

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h3>Files uploaded successfully to " + uploadPath + "</h3>");
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return null;
    }
    
    private boolean isImageFile(String fileName) {
        if (fileName == null) return false;
        
        String lowerCaseFileName = fileName.toLowerCase();
        for (String extension : ALLOWED_IMAGE_EXTENSIONS) {
            if (lowerCaseFileName.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}
