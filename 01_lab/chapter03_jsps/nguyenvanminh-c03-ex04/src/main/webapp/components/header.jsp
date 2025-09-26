<div style="padding: 50px 25px; background-color: burlywood; display: flex; justify-content: space-between;">
    <a style="font-size: 20px; font-weight: bold; text-transform: uppercase; color: black"
       href="${pageContext.request.contextPath}/books">nvminh162's store</a>
    <div style="gap: 20px; display: flex;">
        <a style="font-size: 20px; font-weight: bold; text-transform: uppercase; color: black"
           href="${pageContext.request.contextPath}/cart">Cart (${sessionScope.cart != null ? sessionScope.cart.cartItems.size() : 0})</a>
    </div>
</div>