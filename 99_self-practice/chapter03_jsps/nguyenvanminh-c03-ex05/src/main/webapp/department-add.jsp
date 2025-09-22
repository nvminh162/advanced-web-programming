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
    <h1>Department Information</h1>
    <form action="department" method="post">
        <input type="hidden" name="action" value="add">
        <label for="department-name"></label><input type="text" name="department-name" id="department-name"
                                                    placeholder="Enter your department name" value="E-Town 3" required>
        <br/>
        <button type="submit">Save</button>
    </form>
</div>
</body>
</html>
