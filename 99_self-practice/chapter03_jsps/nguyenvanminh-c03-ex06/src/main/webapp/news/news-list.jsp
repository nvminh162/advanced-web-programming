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
<h1>Tin tức</h1>
<div>
    <a href="${pageContext.request.contextPath}/news?action=create">Thêm tin tức</a>
</div>
<table style="width: 100%">
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Nội dung TT</th>
        <th>Lien kết</th>
        <th>Danh mục</th>
        <th>Hành động</th>
    </tr>
    <c:forEach items="${newsList}" var="news">
        <tr>
            <td>${news.id}</td>
            <td>${news.tieuDe}</td>
            <td>${news.noiDungTT}</td>
            <td>${news.lienKet}</td>
            <td>${news.catalog.id}</td>
            <td style="display: flex; gap: 10px;">
                <a href="${pageContext.request.contextPath}/news?action=update&tintuc-id=${news.id}">Update</a>
                <form action="news" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="tin-tuc-id" value="${news.id}">
                    <button type="submit">
                        Delete
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>

</html>
