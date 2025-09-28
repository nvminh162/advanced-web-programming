<jsp:useBean id="accounts" scope="request" type="java.util.List"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/28/2025
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account List</title>
    <style>
        table {
            width: 100%;
        }

        td, th {
            border: 1px solid black;
        }

        td {
            text-align: center;
            padding: 5px;
        }
    </style>
</head>
<body>
<h1>Account List</h1>
<a href="accounts?action=account-form">Add new account</a>
<form action="accounts" method="get">
    <label for="action"></label>
    <select name="action" id="action">
        <option value="filter-address">Address</option>
        <option value="filter-amount-range">Amount Range</option>
    </select>
    <div style="display: flex; justify-content: space-between;">
        <div>
            <label for="filter-address">Filter Address</label>
            <input type="text" name="filter-address" id="filter-address">
        </div>
        <div>
            <button type="submit">Tìm kiếm</button>
            <button type="reset">Reset</button>
        </div>
        <div>
            <label for="filter-amount-range">Filter Amount Range</label>
            <label for="filter-amount-min"></label><input type="number" name="filter-amount-min" id="filter-amount-min"
                                                          placeholder="Min"
        >
            <label for="filter-amount-max"></label><input type="number" name="filter-amount-max" id="filter-amount-max"
                                                          placeholder="Max"
        >
        </div>
    </div>
</form>
<table>
    <tr>
        <th>Account Number</th>
        <th>Owner Name</th>
        <th>Card Number</th>
        <th>Owner Address</th>
        <th>Amount</th>
    </tr>
    <c:forEach items="${accounts}" var="account">
        <tr>
            <td>${account.accountNumber}</td>
            <td>${account.ownerName}</td>
            <td>${account.cardNumber}</td>
            <td>${account.ownerAddress}</td>
            <td>${account.amount}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
