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
<h1>Book detail</h1>
<table style="width: 100%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>Image</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Action</th>
    </tr>
    <jsp:useBean id="book" scope="request" type="com.nvminh162.nguyenvanminh.model.Book"/>
    <c:if test="${not empty book}">
        <tr>
            <td>${fn:substring(book.id, 0, 5)}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>
                <img style="width: 80px; height: 100px" src="images/${book.image}" alt="${book.name}">
            </td>
            <td>
                <fmt:formatNumber value="${book.price}" type="number" />đ
            </td>
            <td>${book.quantity}</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="create">
                    <input type="hidden" name="book-id" value="${book.id}">
                    <button type="submit">Add to cart</button>
                </form>
            </td>
        </tr>
    </c:if>
    <c:if test="${empty book}">
        <tr>
            <td style="padding: 50px" colspan="7">Trống</td>
        </tr>
    </c:if>
</table>
<a href="books">Books</a>
</body>
</html>
