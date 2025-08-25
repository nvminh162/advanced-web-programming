<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 8/25/2025
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>Xin chào, ${sessionScope.user}</h2>
  <a href="${pageContext.request.contextPath}/bai05/secure/Secret.jsp">Trang bảo mật</a><br>
  <a href="${pageContext.request.contextPath}/bai05/logout">Đăng xuất</a>
</body>
</html>
