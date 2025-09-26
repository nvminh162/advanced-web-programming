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
<h1>News Update</h1>
<form action="news" method="post">
    <input type="hidden" name="action" value="update"/>
    <div>
        <label for="tin-tuc-id">ID</label>
        <input type="text" name="tin-tuc-id" id="tin-tuc-id" value="${news.id}" readonly/>
    </div>
    <div>
        <label for="tieu-de">Tiêu đề</label>
        <input type="text" name="tieu-de" id="tieu-de" value="${news.tieuDe}"/>
    </div>
    <div>
        <label for="noi-dung-tt">Nội dung TT</label>
        <input type="text" name="noi-dung-tt" id="noi-dung-tt" value="${news.noiDungTT}"/>
    </div>
    <div>
        <label for="lien-ket">Liên kết</label>
        <input type="text" name="lien-ket" id="lien-ket" value="${news.lienKet}"/>
    </div>
    <div>
        <label for="tintuc-danhmuc-id">Danh mục</label><select name="tintuc-danhmuc-id" id="tintuc-danhmuc-id" required>
        <c:forEach var="catalog" items="${catalogList}">
            <option selected="${news.catalog.id}" value="${catalog.id}">${catalog.tenDanhMuc}</option>
        </c:forEach>
    </select>
    </div>
    <button type="submit">Save</button>
</form>
</body>
</html>
