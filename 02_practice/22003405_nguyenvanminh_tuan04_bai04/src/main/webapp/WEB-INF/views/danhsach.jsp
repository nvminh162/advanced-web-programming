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
    <title>Danh Sách Sách</title>
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

        .book-card {
            border: 2px solid #ddd;
            border-radius: 8px;
            padding: 15px;
            margin-bottom: 20px;
            background: #f9f9f9;
            text-align: center;
            transition: transform 0.3s ease;
        }

        .book-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        }

        .book-image {
            width: 150px;
            height: 200px;
            object-fit: cover;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        .book-price {
            color: #d63384;
            font-weight: bold;
            font-size: 1.1rem;
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
                <c:choose>
                    <c:when test="${not empty searchKeyword}">
                        <h3 class="mb-2 text-center">Kết quả tìm kiếm</h3>
                        <p class="text-center text-muted mb-4">Tìm thấy ${books.size()} kết quả cho từ khóa: <strong>"${searchKeyword}"</strong></p>
                    </c:when>
                    <c:otherwise>
                        <h3 class="mb-4 text-center">Danh Sách Sách</h3>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${empty books}">
                        <div class="text-center mt-5">
                            <h5 class="text-muted">Không tìm thấy sách nào</h5>
                            <c:if test="${not empty searchKeyword}">
                                <p>Thử tìm kiếm với từ khóa khác hoặc <a href="${pageContext.request.contextPath}/books">xem tất cả sách</a></p>
                            </c:if>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="row">
                            <%-- Item--%>
                            <c:forEach items="${books}" var="book">
                                <div class="col-md-4">
                                    <div class="book-card">
                                        <img src="images/${book.image}" alt="${book.name}"
                                             class="book-image">
                                        <h4 class="mt-2">${book.name}</h4>
                                        <h6 class="mt-2">Tác giả: ${book.author}</h6>
                                        <p class="book-price">Price: <fmt:formatNumber value="${book.price}" type="number" groupingUsed="true" />đ</p>
                                        <p class="text-muted small">Quantity: ${book.quantity}</p>
                                        <form action="${pageContext.request.contextPath}/cart" method="post" class="d-grid gap-2">
                                            <a href="${pageContext.request.contextPath}/book?id=${book.id}" class="btn btn-outline-primary btn-sm">Details</a>
                                            <input type="hidden" name="id" value="${book.id}">
                                            <input type="hidden" name="action" value="add">
                                            <button class="btn btn-success btn-sm">Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
</body>
</html>
