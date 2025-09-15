<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/14/2025
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }

        .form-container {
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            padding: 30px;
            border: 2px solid #ccc;
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
            font-size: 24px;
        }

        .form-row {
            display: flex;
            margin-bottom: 15px;
            align-items: center;
        }

        .form-row label {
            display: block;
            margin-bottom: 5px;
            font-weight: normal;
            min-width: 100px;
            margin-right: 20px;
        }

        .form-row input[type="text"],
        .form-row input[type="email"],
        .form-row input[type="date"],
        .form-row textarea,
        .form-row select {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            flex: 1;
        }

        .form-row.half .form-group {
            flex: 1;
            margin-right: 10px;
        }

        .form-row.half .form-group:last-child {
            margin-right: 0;
        }

        .form-group {
            display: flex;
            flex-direction: column;
        }

        .radio-group {
            display: flex;
            align-items: center;
            gap: 20px;
            flex: 1;
        }

        .radio-group input[type="radio"] {
            margin-right: 5px;
        }

        .checkbox-group {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            flex: 1;
        }

        .checkbox-group input[type="checkbox"] {
            margin-right: 5px;
        }

        textarea {
            resize: vertical;
            height: 80px;
        }

        .qualification-section {
            margin-top: 20px;
        }

        .qualification-title {
            font-weight: bold;
            margin-bottom: 15px;
            color: #333;
        }

        .qualification-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        .qualification-table th,
        .qualification-table td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }

        .qualification-table th {
            background-color: #f8f8f8;
            font-weight: bold;
        }

        .qualification-table input {
            width: 100%;
            border: none;
            padding: 5px;
            background: transparent;
        }

        .course-section {
            margin-bottom: 20px;
        }

        .course-options {
            display: flex;
            gap: 20px;
            flex: 1;
        }

        .course-options input[type="checkbox"] {
            margin-right: 5px;
        }

        .button-group {
            text-align: center;
            margin-top: 30px;
        }

        .button-group input[type="submit"],
        .button-group input[type="reset"] {
            padding: 10px 20px;
            margin: 0 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }

        .button-group input[type="submit"] {
            background-color: #007bff;
            color: white;
        }

        .button-group input[type="reset"] {
            background-color: #6c757d;
            color: white;
        }

        .button-group input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .button-group input[type="reset"]:hover {
            background-color: #545b62;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>Student Registration Form</h1>

    <form action="student" method="post">
        <!-- Name fields -->
        <div class="form-row half">
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="text" id="firstName" name="firstName" required>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName" required>
            </div>
        </div>

        <!-- Date of Birth -->
        <div class="form-row">
            <label for="dob">Date of Birth</label>
            <input type="date" id="dob" name="dob" placeholder="dd/mm/yyyy" required>
        </div>

        <!-- Email and Mobile -->
        <div class="form-row half">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="mobile">Mobile</label>
                <input type="text" id="mobile" name="mobile" required>
            </div>
        </div>

        <!-- Gender -->
        <div class="form-row">
            <label>Gender</label>
            <div class="radio-group">
                <label><input type="radio" name="gender" value="male" required> Male</label>
                <label><input type="radio" name="gender" value="female" required> Female</label>
            </div>
        </div>

        <!-- Address -->
        <div class="form-row">
            <label for="address">Address</label>
            <textarea id="address" name="address" required></textarea>
        </div>

        <!-- City and Pin Code -->
        <div class="form-row half">
            <div class="form-group">
                <label for="city">City</label>
                <input type="text" id="city" name="city" required>
            </div>
            <div class="form-group">
                <label for="pinCode">Pin Code</label>
                <input type="text" id="pinCode" name="pinCode" required>
            </div>
        </div>

        <!-- State and Country -->
        <div class="form-row half">
            <div class="form-group">
                <label for="state">State</label>
                <input type="text" id="state" name="state" required>
            </div>
            <div class="form-group">
                <label for="country">Country</label>
                <input type="text" id="country" name="country" value="India" required>
            </div>
        </div>

        <!-- Hobbies -->
        <div class="form-row">
            <label>Hobbies</label>
            <div class="checkbox-group">
                <label><input type="checkbox" name="hobbies" value="drawing"> Drawing</label>
                <label><input type="checkbox" name="hobbies" value="singing"> Singing</label>
                <label><input type="checkbox" name="hobbies" value="dancing"> Dancing</label>
                <label><input type="checkbox" name="hobbies" value="sketching"> Sketching</label>
                <label><input type="checkbox" name="hobbies" value="others"> Others</label>
            </div>
        </div>

        <!-- Qualification Section -->
        <div class="qualification-section">
            <div class="qualification-title">Qualification</div>

            <table class="qualification-table">
                <thead>
                <tr>
                    <th>Sl.No</th>
                    <th>Examination</th>
                    <th>Board</th>
                    <th>Percentage</th>
                    <th>Year of Passing</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td><input type="text" name="exam1" value="Class X"></td>
                    <td><input type="text" name="board1"></td>
                    <td><input type="text" name="percentage1"></td>
                    <td><input type="text" name="year1"></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td><input type="text" name="exam2" value="Class XII"></td>
                    <td><input type="text" name="board2"></td>
                    <td><input type="text" name="percentage2"></td>
                    <td><input type="text" name="year2"></td>
                </tr>
                </tbody>
            </table>
        </div>

        <!-- Course Applied For -->
        <div class="form-row course-section">
            <label>Course applied for</label>
            <div class="course-options">
                <label><input type="checkbox" name="courses" value="bca"> BCA</label>
                <label><input type="checkbox" name="courses" value="bcom"> B.Com</label>
                <label><input type="checkbox" name="courses" value="bsc"> B.Sc</label>
                <label><input type="checkbox" name="courses" value="ba"> B.A</label>
            </div>
        </div>

        <!-- Submit and Reset buttons -->
        <div class="button-group">
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </form>
</div>
</body>
</html>