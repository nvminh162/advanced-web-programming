<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/14/2025
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send Mail</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }
        .form-container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            max-width: 500px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: inline-block;
            width: 80px;
            font-weight: bold;
        }
        input[type="email"], input[type="text"] {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
            width: 200px;
        }
        textarea {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
            width: 350px;
            height: 100px;
            resize: vertical;
        }
        .file-group {
            margin-bottom: 15px;
        }
        input[type="file"] {
            margin-right: 10px;
        }
        .file-status {
            font-style: italic;
            color: #666;
        }
        button {
            background-color: #f0f0f0;
            border: 1px solid #ccc;
            padding: 8px 15px;
            border-radius: 3px;
            cursor: pointer;
        }
        button:hover {
            background-color: #e0e0e0;
        }
    </style>
</head>
<body>
<div class="form-container">
    <form action="send-mail" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="recipient">Người nhận:</label>
            <input type="email" id="recipient" name="recipient" value="nvminh162@gmail.com" required>
        </div>

        <div class="form-group">
            <label for="subject">Tiêu đề:</label>
            <input type="text" id="subject" name="subject" value="WWW - Chapter 02 - Exercise 08" required>
        </div>

        <div class="form-group">
            <label for="content">Nội dung:</label>
            <br>
            <textarea id="content" name="content" placeholder="Nhập nội dung email...">Test send email pratice lab</textarea>
        </div>

        <div class="file-group">
            <label>File đính kèm:</label>
            <input type="file" id="attachment" name="attachment">
            <span class="file-status">Không có tệp nào được chọn</span>
        </div>

        <div>
            <button type="submit">Gửi mail</button>
        </div>
    </form>
</div>

<script>
    // JavaScript để cập nhật trạng thái file được chọn
    document.getElementById('attachment').addEventListener('change', function(e) {
        const fileStatus = document.querySelector('.file-status');
        if (e.target.files.length > 0) {
            fileStatus.textContent = e.target.files[0].name + ' đã được chọn';
            fileStatus.style.color = '#333';
        } else {
            fileStatus.textContent = 'Không có tệp nào được chọn';
            fileStatus.style.color = '#666';
        }
    });
</script>
</body>
</html>