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
    <h1>Department List</h1>
    <a href="${pageContext.request.contextPath}/">Add Department</a>
    <form action="departments" method="get">
        <label for="department-name">Search Department with name:</label>
        <input type="text" name="department-name" id="department-name">
        <button type="submit">Search</button>
    </form>
    <table style="width: 100%; text-align: left;">
        <tr>
            <th>Dept ID</th>
            <th>Dept Name</th>
            <th>Action</th>
        </tr>
        <jsp:useBean id="departments" scope="request" type="java.util.List"/>
        <c:forEach items="${departments}" var="department">
            <tr>
                <td style="border: 1px solid #cccc;">${department.id}</td>
                <td style="border: 1px solid #cccc;">${department.name}</td>
                <td style="border: 1px solid #cccc; display: flex;">
                    <a href="${pageContext.request.contextPath}/">Edit</a>
                    <form action="department" method="post">
                        <input type="hidden" name="departmentId" value="${department.id}">
                        <input type="hidden" name="action" value="delete">
                        <button style="border: none; background-color: transparent; text-decoration: underline; font-size: 16px;"
                                type="submit">Delete
                        </button>
                    </form>
                    <a href="${pageContext.request.contextPath}/">Employees</a>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
