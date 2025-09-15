<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div class="col-md-3 sidebar">
    <div class="mb-4">
        <h5 class="text-muted">ABOUT US</h5>
        <p class="small">About us information will be here... <a href="#" class="text-decoration-none">Read More
            »</a></p>
    </div>

    <div class="mb-4">
        <h5 class="text-muted">SEARCH SITE</h5>
        <form action="${pageContext.request.contextPath}/books" method="get">
            <div class="input-group">
                <input type="text" class="form-control form-control-sm"
                       name="search"
                       placeholder="Tìm kiếm sách..."
                       value="${searchKeyword}">
                <button class="btn btn-outline-secondary btn-sm" type="submit">
                    🔍
                </button>
            </div>
        </form>
        <c:if test="${not empty searchKeyword}">
            <div class="mt-2">
                <small class="text-muted">Kết quả cho: <strong>"${searchKeyword}"</strong></small>
                <a href="${pageContext.request.contextPath}/books" class="btn btn-link btn-sm p-0 ms-2">Xóa</a>
            </div>
        </c:if>
    </div>
</div>