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
    <div style="flex: 1; padding: 32px; display: flex; flex-wrap: wrap; align-items: flex-start;">
        <c:if test="${empty cart.cartItems}">
            <div style="width: 100%; text-align: center;">
                <p>Books is empty!</p>
            </div>
        </c:if>
        <c:if test="${not empty cart.cartItems}">
            <table style="width: 100%; text-align: center; border: 1px solid #ccc">
                <tr>
                    <td colspan="6" style="padding: 15px 10px;">
                        <form action="${pageContext.request.contextPath}/cart" method="post">
                            <input type="hidden" name="action" value="clear"/>
                            <button type="submit">Clear</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${cart.cartItems}" var="item">
                    <tr>
                        <td>${item.book.id}</td>
                        <td>${item.book.name}</td>
                        <td><fmt:formatNumber value="${item.book.price}" type="number" groupingUsed="true"/>đ</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/cart" method="post">
                                <input type="hidden" name="bookId" value="${item.book.id}"/>
                                <input type="hidden" name="action" value="update"/>
                                <input type="number" value="${item.quantity}" name="quantity" min="1"
                                       max="${item.book.quantity}"
                                       onchange="this.form.submit()">
                            </form>
                        </td>
                        <td><fmt:formatNumber value="${item.quantity * item.book.price}" type="number"
                                              groupingUsed="true"/>đ
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/cart" method="post">
                                <input type="hidden" name="bookId" value="${item.book.id}"/>
                                <input type="hidden" name="action" value="remove"/>
                                <button type="submit">Remove</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr style="font-weight: bold;">
                    <td style="text-align: left; padding: 15px 10px;" colspan="5">Tổng tiền</td>
                    <td style="padding: 15px 10px;">
                        <fmt:formatNumber value="${cart.getTotalInCart()}" type="number" groupingUsed="true"/>đ
                    </td>
                </tr>
                <tr style="font-weight: bold;">
                    <td style="text-align: left; padding: 15px 10px;" colspan="5">
                        <a href="${pageContext.request.contextPath}/payment">Payment</a>
                    </td>
                </tr>
            </table>
        </c:if>

    </div>
</div>

<%-- footer --%>
<jsp:include page="./components/header.jsp"/>
</body>
</html>