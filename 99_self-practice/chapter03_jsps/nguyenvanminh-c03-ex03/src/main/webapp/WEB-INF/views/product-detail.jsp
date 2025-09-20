<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/17/2025
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Product Detail</h2>
<c:if test="${not empty product}">
    <ul>
        <li>Id: ${product.id}</li>
        <li>Model: ${product.model}</li>
        <li>Description: ${product.description}</li>
        <li>Quantity: ${product.quantity}</li>
        <li>Price: ${product.price}</li>


        <img src="${pageContext.request.contextPath}/images/${product.image}"
             alt="${product.model}" width="150"/>
        <br/>
    </ul>
</c:if>

<p>
    <a href="${pageContext.request.contextPath}/product">Back to Product List</a>
</p>
</body>
</html>
