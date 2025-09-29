<jsp:useBean id="danhSachThuoc" scope="request" type="java.util.List"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/28/2025
  Time: 12:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            width: 100%;
        }

        th, td {
            border: 1px solid #cccccc;
            padding: 10px;
        }

        td {
            text-align: center;
        }
    </style>
</head>
<body>
<h1 style="padding: 50px; text-align: center; border: 1px solid #cccccc">Nguyễn Văn Minh - 22003405</h1>
<hr/>
<div style="display: flex; justify-content: space-between;">
    <h2>Danh sách thuốc</h2>
    <a href="thuoc?action=them-thuoc">Thêm thuốc</a>
    <a href="thuoc?action=danh-sach-loai-thuoc">Danh sách loại thuốc</a>
</div>
<table>
    <tr>
        <th>Mã thuốc</th>
        <th>Tên thuốc</th>
        <th>Giá</th>
        <th>Năm SX</th>
        <th>Loại thuốc</th>
    </tr>
    <c:forEach items="${danhSachThuoc}" var="thuoc">
        <tr>
            <td>${thuoc.maThuoc}</td>
            <td>${thuoc.tenThuoc}</td>
            <td>${thuoc.gia}</td>
            <td>${thuoc.namSX}</td>
            <td>${thuoc.loaiThuoc.tenLoai}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
