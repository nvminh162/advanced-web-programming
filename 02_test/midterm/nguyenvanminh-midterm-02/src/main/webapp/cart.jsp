<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/26/2025
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <style>
        th, td {
            border: 1px solid black;
        }

        td {
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Cart</h1>
<table style="width: 100%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>Image</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>SubTotal</th>
        <th>Action</th>
    </tr>
    <jsp:useBean id="cart" scope="request" type="com.nvminh162.nguyenvanminh.bean.Cart"/>
    <c:forEach items="${cart.cartItems}" var="item">
        <tr>
            <td>${fn:substring(item.book.id, 0, 5)}</td>
            <td>${item.book.name}</td>
            <td>${item.book.author}</td>
            <td>
                <img style="width: 80px; height: 100px" src="images/${item.book.image}" alt="${item.book.name}">
            </td>
            <td>
                <fmt:formatNumber value="${item.book.price}" type="number"/>đ
            </td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="book-id" value="${item.book.id}">
                    <label for="quantity"></label>
                    <input type="number" name="quantity" id="quantity" value="${item.quantity}" min="0"
                           max="${item.book.quantity}" onchange="this.form.submit()">
                </form>
            </td>
            <td>
                <fmt:formatNumber value="${item.cartItemTotal}" type="number"/>đ
            </td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="remove">
                    <input type="hidden" name="book-id" value="${item.book.id}">
                    <button type="submit">Remove</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${cart.cartItems.size() == 0}">
        <tr style="padding: 200px;">
            <td style="padding: 50px" colspan="8">Trống</td>
        </tr>
    </c:if>
</table>
<a href="books">Books</a>
<a href="orders">Checkout</a>
</body>
</html>
