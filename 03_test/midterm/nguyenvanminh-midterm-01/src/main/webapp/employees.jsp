<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/25/2025
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Employees</title>
    <style>
        th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <h1>Employees</h1>
    <a href="employees?action=create">Add Employee</a>
    <table style="width: 100%; text-align: left;">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Department</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td><fmt:formatNumber value="${employee.salary}" type="number"/></td>
                <td>${employee.department.name}</td>
                <td style="display: flex; gap: 10px;">
                    <a href="employees?action=update&id=${employee.id}">Update</a>
                    <form action="employees" method="post" onsubmit="return confirm('Are you sure?')">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${employee.id}">
                        <input type="hidden" name="department-id" value="${employee.department.id}">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${employees.size() == 0}">
            <tr>
                <td style="text-align: center" colspan="5">Trống</td>
            </tr>
        </c:if>
    </table>
    <a href="departments">Departments</a>
</body>
</html>
