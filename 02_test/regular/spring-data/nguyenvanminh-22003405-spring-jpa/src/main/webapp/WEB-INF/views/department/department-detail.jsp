<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Chi Tiết Phòng Ban</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <div class="row">
            <div class="col-12">
                <h2>Chi Tiết Phòng Ban</h2>
                <a href="/departments" class="btn btn-secondary mb-3">Quay lại</a>
                
                <c:if test="${department != null}">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${department.name}</h5>
                            <p class="card-text"><strong>ID:</strong> ${department.id}</p>
                            <p class="card-text"><strong>Tên Phòng Ban:</strong> ${department.name}</p>
                            
                            <a href="/departments/${department.id}/update" class="btn btn-warning">Chỉnh sửa</a>
                            <form method="POST" action="/departments/${department.id}/delete" style="display: inline;">
                                <button type="submit" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</button>
                            </form>
                        </div>
                    </div>
                </c:if>
                
                <c:if test="${department == null}">
                    <div class="alert alert-warning">
                        Không tìm thấy phòng ban. <a href="/departments">Quay lại danh sách</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
