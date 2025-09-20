<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/15/2025
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Giỏ Hàng - IUH Bookstore</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
            crossorigin="anonymous"></script>
    <style>
        .bookstore-header {
            background: linear-gradient(135deg, #8B7355, #A0937D);
            color: white;
            padding: 20px 0;
        }

        .cart-container {
            background: #f9f9f9;
            border: 2px solid #ddd;
            border-radius: 8px;
            padding: 20px;
            margin: 20px 0;
        }

        .cart-title {
            text-align: center;
            color: #8B7355;
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 20px;
            text-transform: uppercase;
        }

        .cart-table {
            background: white;
            border: 1px solid #ccc;
        }

        .cart-table th {
            background: #6c757d;
            color: white;
            text-align: center;
            padding: 12px;
            font-weight: bold;
            border: 1px solid #555;
        }

        .cart-table td {
            text-align: center;
            padding: 10px;
            border: 1px solid #ddd;
            vertical-align: middle;
        }

        .cart-table tr:nth-child(even) {
            background-color: #f8f9fa;
        }

        .total-row {
            background-color: #e9ecef !important;
            font-weight: bold;
        }

        .total-row td {
            border-top: 2px solid #6c757d;
        }

        .sidebar {
            background-color: #f8f9fa;
            border-right: 1px solid #dee2e6;
            min-height: 500px;
            padding: 20px;
        }

        .nav-link {
            color: white !important;
            font-weight: 500;
        }

        .nav-link:hover {
            background-color: rgba(255, 255, 255, 0.1);
            border-radius: 5px;
        }

        .btn-remove {
            color: #8B7355;
            text-decoration: underline;
            background: none;
            border: none;
            padding: 0;
            font-size: 0.9rem;
        }

        .btn-remove:hover {
            color: #A0937D;
        }

        .cart-actions {
            margin-top: 20px;
            text-align: left;
        }

        .shopping-cart-link {
            color: #8B7355;
            text-decoration: underline;
            font-size: 0.9rem;
        }

        .shopping-cart-link:hover {
            color: #A0937D;
        }

        .quantity-input {
            width: 60px;
            text-align: center;
            border: 1px solid #ccc;
            padding: 5px;
        }
    </style>
</head>
<body>
<jsp:include page="../components/header.jsp" />
<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <jsp:include page="../components/sideBar.jsp" />

        <!-- Main Content -->
        <div class="col-md-9">
            <div class="container mt-4">
                <div class="cart-container">
                    <h3 class="cart-title">YOUR SHOPPING CART</h3>

                    <c:choose>
                        <c:when test="${not empty cart.cartItems}">
                            <table class="table cart-table">
                                <thead>
                                    <tr>
                                        <th>Product ID</th>
                                        <th>Product name</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                        <th>Remove</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${cart.cartItems}">
                                        <tr>
                                            <td>${item.book.id}</td>
                                            <td>${item.book.name}</td>
                                            <td><fmt:formatNumber value="${item.book.price}" type="number" groupingUsed="true" /></td>
                                            <td>
                                                <form action="${pageContext.request.contextPath}/cart" method="post" style="display:inline;">
                                                    <input type="hidden" name="action" value="update">
                                                    <input type="hidden" name="bookId" value="${item.book.id}">
                                                    <input type="number" class="quantity-input" name="quantity" value="${item.quantity}" min="1" onchange="this.form.submit()">
                                                </form>
                                            </td>
                                            <td><fmt:formatNumber value="${item.book.price * item.quantity}" type="number" groupingUsed="true" /></td>
                                            <td>
                                                <form action="${pageContext.request.contextPath}/cart" method="post" style="display:inline;">
                                                    <input type="hidden" name="action" value="remove">
                                                    <input type="hidden" name="bookId" value="${item.book.id}">
                                                    <button type="submit" class="btn-remove">Remove</button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <!-- Total Row -->
                                    <tr class="total-row">
                                        <td colspan="4"></td>
                                        <td><strong>Total price</strong></td>
                                        <td><strong>(VND) <fmt:formatNumber value="${cart.totalPrice}" type="number" groupingUsed="true" /></strong></td>
                                    </tr>
                                </tbody>
                            </table>

                            <div class="cart-actions">
                                <a href="${pageContext.request.contextPath}/checkout" class="btn btn-success me-3">Checkout</a>
                                <a href="${pageContext.request.contextPath}/books" class="btn btn-outline-secondary">Continue shopping</a>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="alert alert-warning text-center">
                                <p>Add some books to your cart to see them here.</p>
                                <a href="${pageContext.request.contextPath}/books" class="btn btn-primary">Back</a>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
