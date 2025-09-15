<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Result</title>
</head>
<body>
<h1>Student Registration Details</h1>
<p><strong>First Name:</strong> ${firstName}</p>
<p><strong>Last Name:</strong> ${lastName}</p>
<p><strong>Date of Birth:</strong> ${dateOfBirth}</p>
<p><strong>Mobile:</strong> ${mobile}</p>
<p><strong>Email:</strong> ${email}</p>
<p><strong>Gender:</strong> ${gender}</p>
<p><strong>Address:</strong> ${address}</p>
<p><strong>City:</strong> ${city}</p>
<p><strong>Pin Code:</strong> ${pinCode}</p>
<p><strong>State:</strong> ${state}</p>
<p><strong>Country:</strong> ${country}</p>
<p><strong>Hobbies:</strong>
    <c:forEach var="hobby" items="${hobbies}">
        ${hobby}
    </c:forEach>
</p>
<p><strong>Course Applied For:</strong> ${course}</p>
</body>
</html>