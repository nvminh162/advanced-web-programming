<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 26/08/2025
  Time: 2:16 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/product" method="post">
    <label> Tên sản phẩm</label>
    <input type="text" name="namepro">
    <br/>
    <label> Gia sản phẩm</label>
    <input type="text" name="pricepro">
    <br/>

    <label> Mo tả sản phẩm</label>
    <input type="text" name="despro">

    <br/>

    <input type="submit" value="Add">

</form>
  
  </body>
</html>
