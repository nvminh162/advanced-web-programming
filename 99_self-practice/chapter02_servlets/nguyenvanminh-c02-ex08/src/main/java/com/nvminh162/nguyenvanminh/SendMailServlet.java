package com.nvminh162.nguyenvanminh;

import java.io.*;
import java.util.Properties;

import jakarta.activation.DataHandler;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Part;

@WebServlet("/send-mail")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,  //  1MB
        maxFileSize = 1024 * 1024 * 10,   // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class SendMailServlet extends HttpServlet {
    private final String USERNAME = "nvminh1602@gmail.com";
    private final String PASSWORD = "";

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("/SendMail.jsp");
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        Part attachment = request.getPart("attachment");

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
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
            // 3. Tạo message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject, "UTF-8");
            // 4. Nội dung chính (text)
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(content, "UTF-8");
            // 5. File đính kèm (nếu có)
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            if (attachment != null && attachment.getSize() > 0) {
                MimeBodyPart attachPart = new MimeBodyPart();
                String fileName = attachment.getSubmittedFileName();
                InputStream fileContent = attachment.getInputStream();
                attachPart.setFileName(fileName);
                attachPart.setDataHandler(new DataHandler(new ByteArrayDataSource(fileContent,
                        getServletContext().getMimeType(fileName))));
                multipart.addBodyPart(attachPart);
            }
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

    public void destroy() {
    }
}