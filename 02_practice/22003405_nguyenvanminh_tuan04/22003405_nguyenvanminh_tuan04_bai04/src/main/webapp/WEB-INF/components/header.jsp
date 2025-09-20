<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="bookstore-header">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-3">
                <a class="nav-link" href="${pageContext.request.contextPath}/books">
                    <h2 class="mb-0">IUH BOOKSTORE</h2>
                </a>
            </div>
            <div class="col-md-9">
                <nav class="navbar navbar-expand-lg">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/cart">CART</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</header>