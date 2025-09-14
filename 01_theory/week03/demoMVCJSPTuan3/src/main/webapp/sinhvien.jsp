<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 26/08/2025
  Time: 12:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Họ tên sinh vien:  ${param.hoten}
<br>
Email:  ${param.email}}
<br>
Ngon ngữ:
<ul>
 <c:forEach var="item" items="${paramValues.lang}">
        <li>${item} </li>
 </c:forEach>
</ul>
<br/>
Số tin chỉ ${param.stc}

<c:set var="credit" value="${param.stc}"/>
<br/>

Đơn gia ${param.price}
    <c:set var="price" value="${param.price}"/>

<br/>

Học phí: <c:out value="${credit*price}"/>

  </body>
</html>
