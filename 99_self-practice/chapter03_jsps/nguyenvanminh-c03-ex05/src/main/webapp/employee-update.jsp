<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/21/2025
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="./components/header.jsp"/>
<div>
    <h1>Employee Information</h1>
    <form action="employee" method="post">
        <input type="hidden" name="action" value="update">
        <label for="employee-id">ID</label><input type="text" name="employee-id" id="employee-id"
                                                  value="${employee.id}"
                                                  readonly>
        <br/>
        <label for="employee-name">Name</label><input type="text" name="employee-name" id="employee-name"
                                                    placeholder="Enter your employee name" value="${employee.name}">
        <label for="employee-salary">Salary</label><input type="number" name="employee-salary" id="employee-salary"
                                                  placeholder="Enter your employee salary" value="${employee.salary.longValue()}">
        <label for="employee-department-id">Department</label><input type="text" name="employee-department-id" id="employee-department-id"
                                                  placeholder="Enter your employee department-id" value="${employee.department.id}">
        <br/>
        <button type="submit">Update</button>
    </form>
    <a href="${pageContext.request.contextPath}/departments">Departments</a>
</div>
</body>
</html>
