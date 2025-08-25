<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/25/2025
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gửi Email</title>
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
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            max-width: 600px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: inline-block;
            width: 100px;
            font-weight: bold;
        }
        input[type="email"], input[type="text"], input[type="file"] {
            width: 300px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        textarea {
            width: 400px;
            height: 100px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }
        .btn {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Gửi Email</h2>
        <form action="sendmail" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="recipient">Người nhận:</label>
                <input type="email" id="recipient" name="recipient" value="dththua79@gmail.com" required>
            </div>
            
            <div class="form-group">
                <label for="subject">Tiêu đề:</label>
                <input type="text" id="subject" name="subject" value="Lập trình WWW" required>
            </div>
            
            <div class="form-group">
                <label for="content">Nội dung:</label><br>
                <textarea id="content" name="content" placeholder="Nhập nội dung email..."></textarea>
            </div>
            
            <div class="form-group">
                <label for="attachment">File đính kèm:</label>
                <input type="file" id="attachment" name="attachment" multiple>
                <small>Không có tệp nào được chọn</small>
            </div>
            
            <div class="form-group">
                <button type="submit" class="btn">Gửi mail</button>
                <button type="reset" class="btn" style="background-color: #6c757d;">Reset</button>
            </div>
        </form>
    </div>

    <script>
        // JavaScript để hiển thị tên file được chọn
        document.getElementById('attachment').addEventListener('change', function(e) {
            const fileInput = e.target;
            const small = fileInput.nextElementSibling;
            
            if (fileInput.files.length > 0) {
                const fileNames = Array.from(fileInput.files).map(file => file.name).join(', ');
                small.textContent = fileNames;
            } else {
                small.textContent = 'Không có tệp nào được chọn';
            }
        });
    </script>
</body>
</html>
