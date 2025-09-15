<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="student" scope="request" type="com.nvminh162.nguyenvanminh.Student"/>

<!DOCTYPE html>
<html>
<head>
    <title>Student Result</title>
</head>
<body>
<h2>Student Information</h2>
<p><b>Name:</b> ${student.firstName} ${student.lastName}</p>
<p><b>Date of Birth:</b> ${student.dateOfBirth}</p>
<p><b>Email:</b> ${student.email}</p>
<p><b>Mobile:</b> ${student.mobile}</p>
<p><b>Gender:</b> ${student.gender}</p>
<p><b>Address:</b> ${student.address}, ${student.city}, ${student.state}, ${student.country}</p>
<p><b>Pin Code:</b> ${student.pinCode}</p>

<h3>Educational Background:</h3>
<p><b>Examination 1:</b> ${student.examination1} - ${student.board1} - ${student.percentage1}%
    - ${student.yearOfPassing1}</p>
<p><b>Examination 2:</b> ${student.examination2} - ${student.board2} - ${student.percentage2}%
    - ${student.yearOfPassing2}</p>

<h3>Hobbies:</h3>
<ul>
    <c:forEach var="hobby" items="${student.hobbies}">
        <li>${hobby}</li>
    </c:forEach>
</ul>

<h3>Courses Applied For:</h3>
<ul>
    <c:forEach var="course" items="${student.coursesAppliedFor}">
        <li>${course}</li>
    </c:forEach>
</ul>
</body>
</html>