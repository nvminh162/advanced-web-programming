<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Chi Tiết Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <div class="row">
            <div class="col-12">
                <h2>Chi Tiết Nhân Viên</h2>
                <a href="/employees" class="btn btn-secondary mb-3">Quay lại</a>
                
                <c:if test="${employee != null}">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${employee.name}</h5>
                            <p class="card-text"><strong>ID:</strong> ${employee.id}</p>
                            <p class="card-text"><strong>Tuổi:</strong> ${employee.age} tuổi</p>
                            <p class="card-text">
                                <strong>Lương:</strong> 
                                <fmt:formatNumber value="${employee.salary}" type="number" maxFractionDigits="0"/>₫
                            </p>
                            <p class="card-text">
                                <strong>Phòng Ban:</strong> 
                                <c:if test="${employee.department != null}">
                                    ${employee.department.name}
                                </c:if>
                                <c:if test="${employee.department == null}">
                                    Chưa phân công
                                </c:if>
                            </p>
                            <a href="/employees/${employee.id}/update" class="btn btn-warning">Chỉnh sửa</a>
                            <form method="POST" action="/employees/${employee.id}/delete" style="display: inline;">
                                <button type="submit" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</button>
                            </form>
                        </div>
                    </div>
                </c:if>
                
                <c:if test="${employee == null}">
                    <div class="alert alert-warning">
                        Không tìm thấy nhân viên. <a href="/employees">Quay lại danh sách</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>