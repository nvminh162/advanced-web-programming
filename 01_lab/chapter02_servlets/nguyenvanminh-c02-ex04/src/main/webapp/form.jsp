<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HTML Form Example with File Upload</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .form-container {
            border: 2px solid #333;
            padding: 20px;
            max-width: 500px;
            margin: 0 auto;
        }
        h1 {
            margin-top: 0;
            font-size: 24px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: inline-block;
            width: 100px;
            font-weight: bold;
        }
        input[type="text"], input[type="password"], input[type="date"], select {
            padding: 5px;
            width: 200px;
            border: 1px solid #ccc;
        }
        input[type="radio"], input[type="checkbox"] {
            margin-right: 5px;
        }
        input[type="file"] {
            margin-left: 5px;
        }
        input[type="submit"] {
            padding: 8px 16px;
            background-color: #f0f0f0;
            border: 1px solid #ccc;
            cursor: pointer;
        }
        .radio-group, .checkbox-group {
            display: inline-block;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>HTML Form Example with File Upload</h1>

    <form action="process-form-upload" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name">
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password">
        </div>

        <div class="form-group">
            <label>Gender:</label>
            <div class="radio-group">
                <input type="radio" id="male" name="gender" value="male" checked>
                <label for="male">Male</label>
                <input type="radio" id="female" name="gender" value="female">
                <label for="female">Female</label>
            </div>
        </div>

        <div class="form-group">
            <label>Hobbies:</label>
            <div class="checkbox-group">
                <input type="checkbox" id="reading" name="hobbies" value="reading">
                <label for="reading">Reading</label>
                <input type="checkbox" id="sports" name="hobbies" value="sports">
                <label for="sports">Sports</label>
                <input type="checkbox" id="music" name="hobbies" value="music">
                <label for="music">Music</label>
            </div>
        </div>

        <div class="form-group">
            <label for="country">Country:</label>
            <select id="country" name="country">
                <option value="vietnam" selected>Vietnam</option>
                <option value="usa">USA</option>
                <option value="japan">Japan</option>
                <option value="korea">Korea</option>
                <option value="china">China</option>
            </select>
        </div>

        <div class="form-group">
            <label for="birthdate">Birth Date:</label>
            <input type="date" id="birthdate" name="birthdate" placeholder="dd/mm/yyyy">
        </div>

        <div class="form-group">
            <label for="profile">Profile Picture:</label>
            <input type="file" id="profile" name="profile" accept="image/*">
            <small>Không có tệp nào được chọn</small>
        </div>

        <div class="form-group">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>

<script>
    // Hiển thị tên file khi được chọn
    document.getElementById('profile').addEventListener('change', function(e) {
        const fileName = e.target.files[0] ? e.target.files[0].name : 'Không có tệp nào được chọn';
        e.target.nextElementSibling.textContent = fileName;
    });
</script>
</body>
</html>