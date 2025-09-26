<jsp:useBean id="cart" scope="request" type="com.nvminh162.nguyenvanminh.bean.Cart"/>
<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/26/2025
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <style>
        th, td {
            border: 1px solid black;
        }

        td {
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Checkout</h1>
<form action="orders" method="post">
    <table style="width: 100%;">
        <tr>
            <th>Full Name</th>
            <td>
                <label for="full-name"></label>
                <input type="text" name="full-name" id="full-name" placeholder="Full Name" required>
            </td>
        </tr>
        <tr>
            <th>Shipping Address</th>
            <td>
                <label for="address"></label>
                <input type="text" name="address" id="address" placeholder="Shipping address" required>
            </td>
        </tr>
        <tr>
            <th>Total Amount</th>
            <td>
                <label for="total-amount"></label>
                <input type="text" name="total-amount" id="total-amount" placeholder="Total amount"
                       value="${cart.cartTotal}" required readonly />
            </td>
        </tr>
        <tr>
            <th>Payment method</th>
            <td>
                <label for="payment-method"></label>
                <select name="payment-method" id="payment-method">
                    <option value="PAYPAL">Paypal</option>
                    <option value="ATM">ATM Debit</option>
                    <option value="VISA">Visa Master Card</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="padding: 200px">
                <button type="submit">Done</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
