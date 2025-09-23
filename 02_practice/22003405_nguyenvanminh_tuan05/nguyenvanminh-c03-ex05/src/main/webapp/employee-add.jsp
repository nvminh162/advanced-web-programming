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
        <input type="hidden" name="action" value="add">
        <label for="employee-name">Name</label><input type="text" name="employee-name" id="employee-name"
                                                      placeholder="Enter your employee name" value="Son Tung MTP" required>
        <br/>
        <label for="employee-salary">Salary</label><input type="number" name="employee-salary" id="employee-salary"
                                                          placeholder="Enter your employee salary" value="20000000"
                                                          required>
        <br/>
        <label for="employee-department-id">Department</label>
        <select name="employee-department-id" id="employee-department-id" required>
            <c:forEach var="department" items="${departments}">
                <option value="${department.id}">${department.name}</option>
            </c:forEach>
        </select>
        <br/>
        <button type="submit">Save</button>
    </form>
</div>
</body>
</html>
