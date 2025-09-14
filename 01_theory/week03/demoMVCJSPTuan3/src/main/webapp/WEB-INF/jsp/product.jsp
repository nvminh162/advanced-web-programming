<%@ page import="fit.se.demomvcjsptuan3.model.Product" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 26/08/2025
  Time: 1:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/addproduct.jsp">Thêm sản phẩm</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Action</th>

    </tr>
    <%
        List<Product> list = (List<Product>) request.getAttribute("lstproduct");
        for (Product p : list) {

    %>
    <tr>
        <td><%=p.getId()%></td>
        <td><%=p.getName()%></td>
        <td><%=p.getPrice()%></td>
        <td><%=p.getDescription()%></td>
        <td>
            <a href="#">Edit</a> |
            <a href="#">Delete</a> |
            <a href="#">Detail</a> |

        </td>

    </tr>

    <% }%>


</table>

</body>
</html>
