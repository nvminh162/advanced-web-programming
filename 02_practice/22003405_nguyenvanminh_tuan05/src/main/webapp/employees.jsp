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
    <h1>Employee List</h1>
    <a href="${pageContext.request.contextPath}/employee-add.jsp">Add Employee</a>
    <form action="employees" method="get">
        <label for="employee-name">Search employee with name:</label>
        <input type="hidden" name="department-id" id="department-id" value="${param['department-id']}">
        <input type="text" name="employee-name" id="employee-name">
        <button type="submit">Search</button>
    </form>
    <table style="width: 100%; text-align: left;">
        <tr>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Employee Salary</th>
            <th>Department</th>
            <th>Action</th>
        </tr>
        <jsp:useBean id="employees" scope="request" type="java.util.List"/>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td style="border: 1px solid #cccc;">${employee.id}</td>
                <td style="border: 1px solid #cccc;">${employee.name}</td>
                <td style="border: 1px solid #cccc;">
                    <fmt:formatNumber value="${employee.salary}" type="number" groupingUsed="true"/>đ
                </td>
                <td style="border: 1px solid #cccc;">${employee.department.id}</td>
                <td style="border: 1px solid #cccc; display: flex;">
                    <a href="${pageContext.request.contextPath}/employee?employee-id=${employee.id}">Edit</a>
                    <form action="employee" method="post">
                        <input type="hidden" name="employee-id" value="${employee.id}">
                        <input type="hidden" name="employee-department-id" value="${employee.department.id}">
                            <%-- ho tro dieu huong --%>
                        <input type="hidden" name="action" value="delete">
                        <button style="border: none; background-color: transparent; text-decoration: underline; font-size: 16px;"
                                type="submit">Delete
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/departments">Departments</a>
</div>
</body>
</html>
