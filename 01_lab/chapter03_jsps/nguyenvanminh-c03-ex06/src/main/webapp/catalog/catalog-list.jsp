<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/23/2025
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 10px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<h1>Danh mục</h1>
<div>
    <a href="${pageContext.request.contextPath}/catalogs?action=create">Thêm danh mục</a>
</div>
<table style="width: 100%">
    <tr>
        <th>ID</th>
        <th>Tên danh mục</th>
        <th>Người quản lý</th>
        <th>Ghi chú</th>
        <th>Hành động</th>
    </tr>
    <c:forEach items="${catalogList}" var="catalog">
        <tr>
            <td>${catalog.id}</td>
            <td>${catalog.tenDanhMuc}</td>
            <td>${catalog.nguoiQuanLy}</td>
            <td>${catalog.ghiChu}</td>
            <td style="display: flex; gap: 10px;">
                <a href="${pageContext.request.contextPath}/catalogs?action=update&danh-muc-id=${catalog.id}">Update</a>
                <form action="catalogs" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="danh-muc-id" value="${catalog.id}">
                    <button type="submit">
                        Delete
                    </button>
                </form>
                <a href="${pageContext.request.contextPath}/news?danh-muc-id=${catalog.id}">News</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>

</html>
