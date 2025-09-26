<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/20/2025
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            box-sizing: border-box;
            padding: 0;
            margin: 0;
        }
    </style>
</head>
<body>
<%-- header --%>
<jsp:include page="./components/header.jsp"/>

<div style="width: 100%; min-height: 100vh; display: flex;">
    <%-- sideBar --%>
    <jsp:include page="./components/sideBar.jsp"/>

    <%-- content --%>
    <div style="flex: 1; padding: 32px; display: flex; flex-wrap: wrap; align-items: flex-start;">
        <c:if test="${empty cart.cartItems}">
            <div style="width: 100%; text-align: center;">
                <p>Books is empty!</p>
            </div>
            <a href="${pageContext.request.contextPath}/books"
               style="display: block; margin: 20px 0;">Back</a>
        </c:if>
        <c:if test="${not empty cart.cartItems}">
            <form action="payment" method="post">
                <div>
                    <label>Full Name</label>
                    <input type="text" name="fullName" required/>
                </div>
                <div>
                    <label>Address</label>
                    <input type="text" name="address" required/>
                </div>
                <div>
                    <label>Total Amount</label>
                    <input type="text" name="totalAmount"
                           value="<fmt:formatNumber value="${cart.getTotalInCart()}" type="number" groupingUsed="true"/>đ"
                           readonly/>
                    <input type="hidden" name="totalAmountDouble"
                           value="${cart.getTotalInCart()}" type="number" groupingUsed="true"/>
                </div>
                <div>
                    <label>Payment Method</label>
                    <br/>
                    <input type="radio" id="visa" name="payment" value="visa"/>
                    <label for="visa">VISA</label>
                    <br/>
                    <input type="radio" id="atm" name="payment" value="atm"/>
                    <label for="atm">ATM</label>
                    <br/>
                    <input type="radio" id="paypal" name="payment" value="paypal"/>
                    <label for="paypal">PAYPAL</label>
                    <br/>
                </div>
                <div>
                    <button type="submit">Confirm</button>
                    <button type="reset">Reset</button>
                </div>
            </form>
        </c:if>

    </div>
</div>

<%-- footer --%>
<jsp:include page="./components/header.jsp"/>
</body>
</html>