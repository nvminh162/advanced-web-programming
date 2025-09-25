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
    <title>Employee Form</title>
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
<h1>Employee Form</h1>
<form action="employees" method="post">
    <c:if test="${not empty employee}">
        <div>
            <label for="id">ID</label>
            <input readonly required type="number" name="id" id="id" value="${employee.id}"/>
        </div>
    </c:if>
    <div>
        <label for="name">Name</label>
        <input required type="text" name="name" id="name" value="${employee.name}"/>
    </div>
    <div>
        <label for="salary">Salary</label>
        <input required type="number" name="salary" id="salary" value="${employee.salary.longValue()}"/>
    </div>
    <div>
        <label for="department-id">Department</label>
        <select name="department-id" id="department-id">
            <c:forEach items="${departments}" var="department">
                <option value="${department.id}">${department.name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <input type="hidden" name="action" value="save">
        <input type="submit" value="Save"/>
    </div>
</form>
</body>
</html>
