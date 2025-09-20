<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/20/2025
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            box-sizing: border-box;
            padding: 0; margin: 0;
        }
    </style>
</head>
<body>
<%-- header --%>
<jsp:include page="./components/header.jsp"/>

<div style="width: 100%; height: 100vh; display: flex;">
    <%-- sideBar --%>
    <div style="width: 500px; padding: 20px; border: 1px solid #ccc; background-color: #f5f5f5;">
        <div>
            <h1 style="margin-top: 0;">About</h1>
            <p>About us information will be here <span><a href="/">Read more</a></span></p>
        </div>

        <div>
            <h1 style="">Search Site</h1>
            <label>
                <input style="width: 100%; padding: 10px;" type="text" placeholder="Search"/>
            </label>
        </div>
    </div>

    <%-- content --%>
    <div style="flex: 1; padding: 32px; display: flex; flex-wrap: wrap; align-items: flex-start">
        <!-- Book 1 -->
        <div style="width: calc(100% / 3); border: 1px solid #333; padding: 16px; text-align: center;">
            <div style="font-size: 16px; font-weight: bold; margin-bottom: 8px;">Sổ tay viết văn - Tác giả: Tô
                Hoài
            </div>
            <img src="assets/book1.jpg" alt="Tô Hoài"
                 style="width: 100%; height: 200px; object-fit: cover; margin-bottom: 8px;"/>
            <div>Price: 99000</div>
            <div>Quantity: 10</div>
            <a href="#" style="display: block; margin: 8px 0;">Product
                details</a>
            <button style="width: 100%; background-color: aqua; padding: 8px; color: #fff; border: none; cursor: pointer;">
                Add to cart
            </button>
        </div>
    </div>
</div>

<%-- footer --%>
<jsp:include page="./components/header.jsp"/>
</body>
</html>