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
<a href="accounts?action=account-list">Account List</a>
<form action="accounts" method="post">
    <table>
        <tr>
            <th>Owner Name</th>
            <td>
                <label for="owner-name"></label>
                <input type="text" name="owner-name" id="owner-name" required placeholder="Owner Name">
            </td>
        </tr>
        <tr>
            <th>Card Number</th>
            <td>
                <label for="card-number"></label>
                <input type="number" name="card-number" id="card-number" required placeholder="Card number">
            </td>
        </tr>
        <tr>
            <th>Owner Address</th>
            <td>
                <label for="owner-address"></label>
                <input type="text" name="owner-address" id="owner-address" required placeholder="Owner Address">
            </td>
        </tr>
        <tr>
            <th>Amount</th>
            <td>
                <label for="amount"></label>
                <input type="number" name="amount" id="amount" required placeholder="Amount">
            </td>
        </tr>
        <tr>
            <td colspan="2" style="padding: 50px">
                <button type="submit">Save</button>
                <br>
                <button type="reset">Clear</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
