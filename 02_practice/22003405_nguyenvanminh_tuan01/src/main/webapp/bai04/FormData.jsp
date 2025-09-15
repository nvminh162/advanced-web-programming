<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Register Form</title>
        <style>
            body {
                background-color: #4d555d;
                font-family: Arial, sans-serif;
                color: white;
            }
            h1 {
                text-align: center;
            }
            form {
                width: 400px;
                margin: 0 auto;
                background-color: #4d555d;
                padding: 20px;
                border-radius: 8px;
            }
            label {
                display: block;
                margin-top: 10px;
                margin-bottom: 5px;
            }
            input[type="text"],
            input[type="email"],
            input[type="password"],
            textarea {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                border: none;
                border-radius: 4px;
            }
            .name-fields {
                display: flex;
                gap: 10px;
            }
            .name-fields input {
                flex: 1;
            }
            input[type="submit"] {
                background-color: white;
                color: black;
                padding: 10px;
                border: none;
                cursor: pointer;
                border-radius: 4px;
            }
            input[type="submit"]:hover {
                background-color: #ddd;
            }
            .note {
                font-size: 12px;
                color: #ccc;
                margin-top: -10px;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Register</h1>
        <form action="${pageContext.request.contextPath}/process-form-upload" method="post" enctype="multipart/form-data">
            <label>Name <span style="color:red">*</span></label>
            <div class="name-fields">
                <input type="text" name="firstName" placeholder="First" required>
                <input type="text" name="lastName" placeholder="Last" required>
            </div>

            <label for="username">Username <span style="color:red">*</span></label>
            <input type="text" id="username" name="username" required>

            <label for="email">E-mail <span style="color:red">*</span></label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password <span style="color:red">*</span></label>
            <input type="password" id="password" name="password" required>

            <label for="facebook">Facebook</label>
            <input type="text" id="facebook" name="facebook">
            <div class="note">Enter your Facebook profile URL.</div>

            <label for="bio">Short Bio</label>
            <textarea id="bio" name="bio" rows="4"></textarea>
            <div class="note">Share a little information about yourself.</div>

            <input type="submit" value="Submit">
        </form>
    </body>
</html>
