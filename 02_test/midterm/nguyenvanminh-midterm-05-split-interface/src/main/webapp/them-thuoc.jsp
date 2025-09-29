<jsp:useBean id="danhSachLoaiThuoc" scope="request" type="java.util.List"/>
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
    <a href="thuoc?action=danh-sach-thuoc">Danh sách thuốc</a>
    <a href="thuoc?action=danh-sach-loai-thuoc">Danh sách loại thuốc</a>
</div>
<form action="thuoc" method="post">
    <table>
        <tr>
            <th>Tên thuốc</th>
            <td>
                <label for="ten-thuoc"></label>
                <input type="text" name="ten-thuoc" id="ten-thuoc" placeholder="Tên thuốc" required>
            </td>
        </tr>
        <tr>
            <th>Giá</th>
            <td>
                <label for="gia"></label>
                <input type="number" name="gia" id="gia" placeholder="Giá" required>
            </td>
        </tr>
        <tr>
            <th>Năm SX</th>
            <td>
                <label for="nam-sx"></label>
                <input type="number" name="nam-sx" id="nam-sx" placeholder="Năm SX" required>
            </td>
        </tr>
        <tr>
            <th>Loại thuốc</th>
            <td>
                <label for="ma-loai"></label>
                <select name="ma-loai" id="ma-loai">
                    <c:forEach items="${danhSachLoaiThuoc}" var="loaiThuoc">
                        <option value="${loaiThuoc.maLoai}">${loaiThuoc.tenLoai}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Save</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
