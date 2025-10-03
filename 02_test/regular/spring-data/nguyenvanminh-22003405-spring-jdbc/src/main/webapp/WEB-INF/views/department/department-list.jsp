<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh Sách Phòng Ban</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <div class="row">
            <div class="col-12">
                <h2>Nguyen Van Minh - 22003405 - Danh Sách Phòng Ban</h2>
                <a href="/departments/create" class="btn btn-primary mb-3">Thêm Phòng Ban</a>
                <a href="/employees" class="btn btn-secondary mb-3">Danh Sách Nhân Viên</a>
                
                <c:if test="${not empty departments}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tên Phòng Ban</th>
                                <th>Thao Tác</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="department" items="${departments}" varStatus="status">
                                <tr>
                                    <td><code class="small">${department.id}</code></td>
                                    <td>${department.name}</td>
                                    <td>
                                        <a href="/departments/${department.id}" class="btn btn-sm btn-info">Xem</a>
                                        <a href="/departments/${department.id}/update" class="btn btn-sm btn-warning">Sửa</a>
                                        <form method="POST" action="/departments/${department.id}/delete" style="display: inline;">
                                            <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                
                <c:if test="${empty departments}">
                    <div class="alert alert-info">
                        Chưa có phòng ban nào. <a href="/departments/create">Thêm phòng ban đầu tiên</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
