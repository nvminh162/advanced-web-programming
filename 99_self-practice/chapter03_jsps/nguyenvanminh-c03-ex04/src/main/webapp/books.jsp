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
    <div style="flex: 1; padding: 32px; display: flex; flex-wrap: wrap; align-items: flex-start">
        <jsp:useBean id="books" scope="request" type="java.util.List"/>
        <c:if test="${empty books}">
            <div style="width: 100%; text-align: center;">
                <p>Books is empty!</p>
            </div>
        </c:if>
        <c:if test="${not empty books}">
            <c:forEach items="${books}" var="book">
                <div style="width: calc(100% / 3); border: 1px solid #333; padding: 16px; text-align: center;">
                    <div style="font-size: 16px; font-weight: bold; margin-bottom: 8px;">${book.name}
                        - ${book.author}</div>
                    <img src="images/${book.image}" alt="${book.name}"
                         style="width: 100%; height: 200px; object-fit: cover; margin-bottom: 8px;"/>
                    <div>Price: <fmt:formatNumber value="${book.price}" type="number" groupingUsed="true" />đ</div>
                    <div>Quantity: ${book.quantity}</div>
                    <a href="${pageContext.request.contextPath}/book?id=${book.id}"
                       style="display: block; margin: 8px 0;">Details</a>
                    <form action="${pageContext.request.contextPath}/cart" method="post">
                        <input type="hidden" name="action" value="add"/>
                        <input type="hidden" name="bookId" value="${book.id}"/>
                        <label style="display: block; margin-bottom: 8px; ">
                            <input style="text-align: center;" type="number" name="quantity" value="1" min="1" max="${book.quantity}"/>
                        </label>
                        <button type="submit" style="background-color: blue; padding: 8px; color: #fff; border: none;">
                            Add to cart
                        </button>
                    </form>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>

<%-- footer --%>
<jsp:include page="./components/header.jsp"/>
</body>
</html>