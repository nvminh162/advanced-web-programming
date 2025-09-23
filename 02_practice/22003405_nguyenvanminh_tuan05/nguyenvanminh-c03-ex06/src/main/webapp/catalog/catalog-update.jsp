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
</head>
<body>
<h1>Catalog Update</h1>
<form action="catalogs" method="post">
    <input type="hidden" name="action" value="update"/>
    <div>
        <label for="danh-muc-id">ID</label>
        <input type="text" name="danh-muc-id" id="danh-muc-id" readonly value="${catalog.id}"/>
    </div>
    <div>
        <label for="danh-muc-id">Tên danh mục</label>
        <input type="text" name="ten-danh-muc" id="ten-danh-muc" value="${catalog.tenDanhMuc}"/>
    </div>
    <div>
        <label for="nguoi-quan-ly">Người Quản lý</label>
        <input type="text" name="nguoi-quan-ly" id="nguoi-quan-ly" value="${catalog.nguoiQuanLy}"/>
    </div>
    <div>
        <label for="ghi-chu">Ghi chú</label>
        <input type="text" name="ghi-chu" id="ghi-chu" value="${catalog.ghiChu}"/>
    </div>
    <button type="submit">Save</button>
</form>
</body>
</html>
