<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/20/2025
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            box-sizing: border-box;
            padding: 0;
            margin: 0;
        }
    </style>
</head>
<body>
<%-- header --%>
<jsp:include page="./components/header.jsp"/>

<div style="width: 100%; min-height: 100vh; display: flex;">
    <%-- sideBar --%>
    <jsp:include page="./components/sideBar.jsp"/>

    <%-- content --%>
    <div style="flex: 1; padding: 32px; display: flex; flex-wrap: wrap;">
        <div style="width: 100%; border: 1px solid #333; padding: 16px; text-align: center;">
            <div style="font-size: 16px; font-weight: bold; margin-bottom: 8px;">${book.name}
                - ${book.author}</div>
            <img src="images/${book.image}" alt="${book.name}"
                 style="width: 100%; height: 500px; object-fit: contain; margin-bottom: 8px;"/>
            <div>Price: <fmt:formatNumber value="${book.price}" type="number" groupingUsed="true" />đ</div>
            <div>Quantity: ${book.quantity}</div>
            <a href="${pageContext.request.contextPath}/books"
               style="display: block; margin: 20px 0;">Back</a>
        </div>
    </div>
</div>

<%-- footer --%>
<jsp:include page="./components/header.jsp"/>
</body>
</html>