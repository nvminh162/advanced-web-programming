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
                <h2>Nguyen Van Minh - 22003405 - Danh Sách Nhân Viên</h2>
                <a href="/employees/create" class="btn btn-primary mb-3">Thêm Nhân Viên</a>
                <a href="/departments" class="btn btn-secondary mb-3">Danh Sách Phòng Ban</a>
                
                <!-- Search Form -->
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title">Tìm Kiếm Nhân Viên</h5>
                        <form method="GET" action="/employees" class="row g-3">
                            <div class="col-md-3">
                                <label for="searchName" class="form-label">Tìm theo tên:</label>
                                <input type="text" class="form-control" id="searchName" name="searchName" 
                                       value="${searchName}" placeholder="Nhập tên nhân viên...">
                            </div>
                            <div class="col-md-2">
                                <label for="searchAge" class="form-label">Tìm theo tuổi:</label>
                                <input type="number" class="form-control" id="searchAge" name="searchAge" 
                                       value="${searchAge}" placeholder="Nhập tuổi..." min="18" max="65">
                            </div>
                            <div class="col-md-3">
                                <label for="departmentId" class="form-label">Tìm theo phòng ban:</label>
                                <select class="form-control" id="departmentId" name="departmentId">
                                    <option value="">-- Chọn phòng ban --</option>
                                    <c:forEach var="dept" items="${departments}">
                                        <option value="${dept.id}" 
                                                <c:if test="${dept.id == departmentId}">selected</c:if>>
                                            ${dept.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="salaryRange" class="form-label">Tìm theo lương:</label>
                                <div class="row g-1">
                                    <div class="col-6">
                                        <input type="number" class="form-control form-control-sm" id="salaryFrom" 
                                               name="salaryFrom" value="${salaryFrom}" placeholder="Từ..." 
                                               min="0">
                                    </div>
                                    <div class="col-6">
                                        <input type="number" class="form-control form-control-sm" id="salaryTo" 
                                               name="salaryTo" value="${salaryTo}" placeholder="Đến..." 
                                               min="0">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <label class="form-label">&nbsp;</label>
                                <div class="d-grid gap-2">
                                    <button type="submit" class="btn btn-success">Tìm kiếm</button>
                                    <a href="/employees" class="btn btn-outline-secondary">Xóa bộ lọc</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                
                <c:if test="${not empty employees}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Tên</th>
                                <th>Email</th>
                                <th>Tuổi</th>
                                <th>Lương</th>
                                <th>Trạng thái</th>
                                <th>Phòng Ban</th>
                                <th>Thao Tác</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="employee" items="${employees}" varStatus="status">
                                <tr>
                                    <td>${status.index + 1}</td>
                                    <td>${employee.name}</td>
                                    <td>${employee.email}</td>
                                    <td>${employee.age} tuổi</td>
                                    <td><fmt:formatNumber value="${employee.salary}" type="number" maxFractionDigits="0"/>₫</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${employee.status == 1}">
                                                <span class="badge bg-success">Hoạt động</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="badge bg-secondary">Không hoạt động</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
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
                        <c:choose>
                            <c:when test="${not empty searchName or not empty searchAge or not empty departmentId or not empty salaryFrom or not empty salaryTo}">
                                Không tìm thấy nhân viên nào phù hợp với tiêu chí tìm kiếm. 
                                <a href="/employees">Xem tất cả nhân viên</a>
                            </c:when>
                            <c:otherwise>
                                Chưa có nhân viên nào. <a href="/employees/create">Thêm nhân viên đầu tiên</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>