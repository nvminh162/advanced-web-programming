package com.nvminh162.nguyenvanminh.bai08;

import jakarta.activation.DataHandler;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet("/bai08/sendmail")
@MultipartConfig
public class SendMailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String USERNAME = "nvminh1602@gmail.com"; // đổi thành email thật
    private final String PASSWORD = "wctp gnvk vqmj gvhb";

    // Bật App password xác thực password mail (Gmail thật)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String to = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        Part filePart = request.getPart("attachment"); // file upload
        
        // Validate required parameters
        if (to == null || to.trim().isEmpty()) {
            throw new ServletException("Email người nhận không được để trống");
        }
        if (subject == null || subject.trim().isEmpty()) {
            throw new ServletException("Tiêu đề email không được để trống");
        }
        if (content == null) {
            content = ""; // Allow empty content
        }
        try {
            // 1. Cấu hình SMTP
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            // 2. Tạo Session có xác thực
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);}
            });
            // 3. Tạo message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject, "UTF-8");
            // 4. Nội dung chính (text)
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(content, "UTF-8");
            // 5. File đính kèm (nếu có)
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            if (filePart != null && filePart.getSize() > 0) {
                MimeBodyPart attachPart = new MimeBodyPart();
                String fileName = filePart.getSubmittedFileName();
                InputStream fileContent = filePart.getInputStream();
                attachPart.setFileName(fileName);
                attachPart.setDataHandler(new DataHandler(new ByteArrayDataSource(fileContent, getServletContext().getMimeType(fileName))));
                multipart.addBodyPart(attachPart); }
            // 6. Gán multipart vào message
            message.setContent(multipart);
            // 7. Gửi mail
            Transport.send(message);
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<h3>Gửi mail thành công!</h3>");
        } catch (Exception e) {
            throw new ServletException("Lỗi gửi mail: " + e.getMessage(), e);
        }
    }
}