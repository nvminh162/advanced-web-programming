<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/26/2025
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
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
<h1>Books</h1>
<form action="books" method="get">
    <input type="hidden" name="action" value="search">
    <label style="display: inline-block; width: 40px;" for="name">Search book name</label>
    <input type="text" name="name" id="name" placeholder="Search by name">
    <button type="submit">Search</button>
</form>
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
    <jsp:useBean id="books" scope="request" type="java.util.List"/>
    <c:forEach items="${books}" var="book">
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
                <a href="book?action=detail&id=${book.id}">Detail</a>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="create">
                    <input type="hidden" name="book-id" value="${book.id}">
                    <button type="submit">Add to cart</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${books.size() == 0}">
        <tr style="padding: 200px;">
            <td style="padding: 50px" colspan="7">Trống</td>
        </tr>
    </c:if>
</table>
<a href="cart">Cart</a>
</body>
</html>
