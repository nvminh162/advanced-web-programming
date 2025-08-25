<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/18/2025
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <div>
            <h1>Form Data</h1>
            <p><strong>First Name:</strong> <%= request.getAttribute("firstName") %></p>
            <p><strong>Last Name:</strong> <%= request.getAttribute("lastName") %></p>
            <p><strong>Username:</strong> <%= request.getAttribute("username") %></p>
            <p><strong>Email:</strong> <%= request.getAttribute("email") %></p>
            <p><strong>Password:</strong> <%= request.getAttribute("password") %></p>
            <p><strong>Facebook:</strong> <%= request.getAttribute("facebook") %></p>
            <p><strong>Bio:</strong> <%= request.getAttribute("bio") %></p>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/">Back to Home</a>
        </div>
    </body>
</html>
