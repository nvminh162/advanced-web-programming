<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/15/2025
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f9;
        color: #333;
    }

    h2 {
        color: #444;
        text-align: center;
        margin-top: 20px;
    }

    a {
        text-decoration: none;
        color: #007bff;
    }

    a:hover {
        text-decoration: underline;
    }

    .product-class {
        border: 1px solid #ddd;
        border-radius: 5px;
        padding: 15px;
        margin: 15px;
        background-color: #fff;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        text-align: center;
        display: inline-block;
        width: 200px;
    }

    .product-class img {
        max-width: 100%;
        height: auto;
        border-radius: 5px;
    }

    .product-class b {
        font-size: 18px;
        color: #333;
    }

    form {
        margin-top: 10px;
    }

    input[type="text"] {
        width: 40px;
        text-align: center;
        border: 1px solid #ddd;
        border-radius: 3px;
        padding: 5px;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 3px;
        padding: 8px 12px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    ul li {
        margin: 5px 0;
    }

    img {
        margin-top: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }

    p {
        text-align: center;
        margin: 20px 0;
    }
</style>
<body>
<p>
    <a href="cart">View Cart</a>
</p>
<c:forEach items="${products}" var="p">
    <div class="product-class">
        <b> ${p.model}</b>
        <br/>
        <img src="images/${p.imgURL}" class="hinh" alt=""> <br/>
        Price: ${p.price}<br/>
        <form action="${pageContext.request.contextPath}/cart" method="post">
            <label>
                <input type="text" size="2" value="1" name="quantity">
            </label> <br/>
            <input type="hidden" name="id" value="${p.id}">
            <input type="hidden" name="price" value="${p.price}">
            <input type="hidden" name="model" value="${p.model}">
            <input type="hidden" name="action" value="add"><br/>
            <input type="submit" name="addToCart" value="Add To Cart"><br/>
        </form>
        <a href="${pageContext.request.contextPath}/product?id=${p.id}">Product Detail</a><br/>
    </div>
</c:forEach>
</body>

</html>
