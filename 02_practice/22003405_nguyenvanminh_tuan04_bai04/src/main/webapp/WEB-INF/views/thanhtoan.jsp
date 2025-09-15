<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/15/2025
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Thanh Toán - IUH Bookstore</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
            crossorigin="anonymous"></script>
    <style>
        .bookstore-header {
            background: linear-gradient(135deg, #8B7355, #A0937D);
            color: white;
            padding: 20px 0;
        }

        .checkout-form {
            background: #f9f9f9;
            border: 2px solid #ddd;
            border-radius: 8px;
            padding: 30px;
            margin: 20px 0;
        }

        .checkout-title {
            text-align: center;
            color: #8B7355;
            font-size: 1.3rem;
            font-weight: bold;
            margin-bottom: 30px;
        }

        .form-label {
            color: #666;
            font-weight: 500;
            margin-bottom: 8px;
        }

        .form-control {
            border: 2px solid #ddd;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 20px;
        }

        .form-control:focus {
            border-color: #8B7355;
            box-shadow: 0 0 5px rgba(139, 115, 85, 0.3);
        }

        .payment-options {
            margin-top: 20px;
        }

        .form-check-input:checked {
            background-color: #8B7355;
            border-color: #8B7355;
        }

        .checkout-actions {
            text-align: center;
            margin-top: 30px;
        }

        .total-display {
            background: #e9ecef;
            padding: 10px;
            border-radius: 5px;
            font-weight: bold;
            color: #8B7355;
        }

        .sidebar {
            background-color: #f8f9fa;
            border-right: 1px solid #dee2e6;
            min-height: 500px;
            padding: 20px;
        }

        .nav-link {
            color: white !important;
            font-weight: 500;
        }

        .nav-link:hover {
            background-color: rgba(255, 255, 255, 0.1);
            border-radius: 5px;
        }
    </style>
</head>
<body>
<jsp:include page="../components/header.jsp" />
<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <jsp:include page="../components/sideBar.jsp" />

        <!-- Main Content -->
        <div class="col-md-9">
            <div class="container mt-4">
                <div class="checkout-form">
                    <h3 class="checkout-title">Checkout - Already registered?</h3>

                    <form action="${pageContext.request.contextPath}/checkout" method="post">
                        <div class="row">
                            <div class="col-md-6">
                                <!-- Fullname -->
                                <div class="mb-3">
                                    <label for="fullname" class="form-label">Fullname</label>
                                    <input type="text" class="form-control" id="fullname" name="fullname" required>
                                </div>

                                <!-- Shipping Address -->
                                <div class="mb-3">
                                    <label for="address" class="form-label">Shipping address</label>
                                    <textarea class="form-control" id="address" name="address" rows="3" required></textarea>
                                </div>

                                <!-- Total Price -->
                                <div class="mb-3">
                                    <label for="total" class="form-label">Total price</label>
                                    <div class="total-display">
                                        <fmt:formatNumber value="${cart.totalPrice}" type="number" groupingUsed="true" /> VND
                                    </div>
                                    <input type="hidden" name="totalPrice" value="${cart.totalPrice}">
                                </div>

                                <!-- Payment Method -->
                                <div class="mb-3">
                                    <label class="form-label">Payment method</label>
                                    <div class="payment-options">
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" name="paymentMethod" id="paypal" value="paypal" checked>
                                            <label class="form-check-label" for="paypal">
                                                Paypal
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" name="paymentMethod" id="atm" value="atm">
                                            <label class="form-check-label" for="atm">
                                                ATM Debit
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" name="paymentMethod" id="visa" value="visa">
                                            <label class="form-check-label" for="visa">
                                                VisaMaster card
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Action Buttons -->
                        <div class="checkout-actions">
                            <button type="submit" class="btn btn-success me-3">Save</button>
                            <a href="${pageContext.request.contextPath}/cart" class="btn btn-outline-secondary">Cancel</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
