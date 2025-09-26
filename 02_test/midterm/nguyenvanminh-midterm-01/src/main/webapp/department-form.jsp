<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/25/2025
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Department Form</title>
    <style>
        label {
            width: 100px;
            display: inline-block;
            text-align: left;
        }
        div {
            margin: 20px;
        }
    </style>
</head>
<body>
<h1>Department Form</h1>
<form action="departments" method="post">
    <c:if test="${not empty department}">
        <div>
            <label for="id">ID</label>
            <input required readonly type="number" name="id" id="id" value="${department.id}"/>
        </div>
    </c:if>
    <div>
        <label for="name">Name</label>
        <input required type="text" name="name" id="name" value="${department.name}"/>
    </div>
    <div>
        <input type="hidden" name="action" value="save">
        <input type="submit" value="Save"/>
    </div>
</form>
</body>
</html>
