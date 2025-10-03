<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Danh Sách Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <div class="row">
            <div class="col-12">
                <h2>Danh Sách Nhân Viên</h2>
                <a href="/employees/create" class="btn btn-primary mb-3">Thêm Nhân Viên</a>
                <a href="/departments" class="btn btn-secondary mb-3">Danh Sách Phòng Ban</a>
                
                <c:if test="${not empty employees}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Tên</th>
                                <th>Tuổi</th>
                                <th>Lương</th>
                                <th>Phòng Ban</th>
                                <th>Thao Tác</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="employee" items="${employees}" varStatus="status">
                                <tr>
                                    <td>${status.index + 1}</td>
                                    <td>${employee.name}</td>
                                    <td>${employee.age} tuổi</td>
                                    <td><fmt:formatNumber value="${employee.salary}" type="number" maxFractionDigits="0"/>₫</td>
                                    <td>
                                        <c:if test="${employee.department != null}">
                                            ${employee.department.name}
                                        </c:if>
                                        <c:if test="${employee.department == null}">
                                            Chưa phân công
                                        </c:if>
                                    </td>
                                    <td>
                                        <a href="/employees/${employee.id}" class="btn btn-sm btn-info">Xem</a>
                                        <a href="/employees/${employee.id}/update" class="btn btn-sm btn-warning">Sửa</a>
                                        <form method="POST" action="/employees/${employee.id}/delete" style="display: inline;">
                                            <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                
                <c:if test="${empty employees}">
                    <div class="alert alert-info">
                        Chưa có nhân viên nào. <a href="/employees/create">Thêm nhân viên đầu tiên</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>