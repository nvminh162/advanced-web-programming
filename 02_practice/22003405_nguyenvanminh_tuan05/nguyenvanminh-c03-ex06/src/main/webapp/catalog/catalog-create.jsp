<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/23/2025
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Catalog Create</h1>
    <form action="catalogs" method="post">
        <input type="hidden" name="action" value="create"/>
        <div>
            <label for="ten-danh-muc">Tên danh mục</label>
            <input type="text" name="ten-danh-muc" id="ten-danh-muc"/>
        </div>
        <div>
            <label for="nguoi-quan-ly">Người Quản lý</label>
            <input type="text" name="nguoi-quan-ly" id="nguoi-quan-ly"/>
        </div>
        <div>
            <label for="ghi-chu">Ghi chú</label>
            <input type="text" name="ghi-chu" id="ghi-chu"/>
        </div>
        <button type="submit">Save</button>
    </form>
</body>
</html>
