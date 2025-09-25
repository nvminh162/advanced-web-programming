<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/25/2025
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@ => taglib => jstl/core --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Departments</title>
    <style>
        th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>Departments</h1>
<a href="departments?action=create">Add department</a>
<table style="width: 100%; text-align: left;">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${departments}" var="department">
        <tr>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td style="display: flex; gap: 10px;">
                <a href="departments?action=update&id=${department.id}">Update</a>
                <form action="departments" method="post" onsubmit="return confirm('Are you sure?')">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${department.id}">
                    <input type="submit" value="Delete">
                </form>
                <a href="employees?department-id=${department.id}">Employees</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${departments.size() == 0}">
        <tr>
            <td style="text-align: center" colspan="3">Trống</td>
        </tr>
    </c:if>
</table>
</body>
</html>
