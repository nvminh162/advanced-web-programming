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
    <title>Chi Tiết Sách - ${book.name}</title>
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

        .book-detail-container {
            background: #f9f9f9;
            border: 2px solid #ddd;
            border-radius: 8px;
            padding: 30px;
            margin: 20px 0;
        }

        .book-detail-image {
            width: 300px;
            height: 400px;
            object-fit: cover;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        }

        .book-detail-info {
            padding-left: 30px;
        }

        .book-title {
            color: #8B7355;
            font-size: 2rem;
            font-weight: bold;
            margin-bottom: 15px;
        }

        .book-author {
            color: #666;
            font-size: 1.2rem;
            margin-bottom: 20px;
        }

        .book-price {
            color: #d63384;
            font-weight: bold;
            font-size: 1.5rem;
            margin-bottom: 15px;
        }

        .book-quantity {
            color: #666;
            font-size: 1.1rem;
            margin-bottom: 25px;
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

        .back-link {
            color: #8B7355;
            text-decoration: underline;
            font-weight: 500;
        }

        .back-link:hover {
            color: #A0937D;
        }

        .detail-header {
            color: #8B7355;
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 20px;
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
                <h3 class="detail-header">Product details: ${book.name}</h3>

                <div class="book-detail-container">
                    <div class="row">
                        <!-- Book Image -->
                        <div class="col-md-5">
                            <img src="${pageContext.request.contextPath}/images/${book.image}"
                                 alt="${book.name}"
                                 class="book-detail-image">
                        </div>

                        <!-- Book Information -->
                        <div class="col-md-7">
                            <div class="book-detail-info">
                                <h2 class="book-title">${book.name}</h2>
                                <p class="book-author">Tác giả: ${book.author}</p>
                                <p class="book-price">Price (VND): <fmt:formatNumber value="${book.price}" type="number" groupingUsed="true" /></p>
                                <p class="book-quantity">Quantity: ${book.quantity}</p>

                                <div class="d-grid gap-2 d-md-flex">
                                    <form action="${pageContext.request.contextPath}/cart" method="post" class="me-2">
                                        <input type="hidden" name="id" value="${book.id}">
                                        <input type="hidden" name="action" value="add">
                                        <button type="submit" class="btn btn-success btn-lg">
                                            <i class="fas fa-cart-plus"></i> Add to Cart
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="mt-4">
                    <a href="${pageContext.request.contextPath}/books" class="back-link">
                        Back to Book List
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
