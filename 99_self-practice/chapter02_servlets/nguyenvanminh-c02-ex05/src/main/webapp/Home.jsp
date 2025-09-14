<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/13/2025
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Xin chào, ${sessionScope.user}!</h2>
<a href="${pageContext.request.contextPath}/secure/Secret.jsp">Trang bảo mật</a><br>
<a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</body>

</html>
