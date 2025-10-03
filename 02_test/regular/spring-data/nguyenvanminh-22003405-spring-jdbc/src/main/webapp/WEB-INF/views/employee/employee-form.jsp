<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Form Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <div class="row">
            <div class="col-12">
                <h2>
                    <c:if test="${employee.id != null}">Cập Nhật Nhân Viên</c:if>
                    <c:if test="${employee.id == null}">Thêm Nhân Viên Mới</c:if>
                </h2>
                <a href="/employees" class="btn btn-secondary mb-3">Quay lại</a>
                
                <form method="POST" action="<c:if test='${employee.id != null}'>/employees/${employee.id}</c:if><c:if test='${employee.id == null}'>/employees</c:if>">
                    <div class="mb-3">
                        <label for="name" class="form-label">Tên Nhân Viên</label>
                        <input type="text" class="form-control" id="name" name="name" value="${employee.name}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="${employee.email}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="age" class="form-label">Tuổi</label>
                        <input type="number" class="form-control" id="age" name="age" value="${employee.age}" required min="18" max="65">
                    </div>
                    
                    <div class="mb-3">
                        <label for="salary" class="form-label">Lương</label>
                        <input type="number" class="form-control" id="salary" name="salary" value="${employee.salary}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="status" class="form-label">Trạng thái</label>
                        <select class="form-select" id="status" name="status" required>
                            <option value="1" <c:if test="${employee.status == 1}">selected</c:if>>Hoạt động</option>
                            <option value="0" <c:if test="${employee.status == 0}">selected</c:if>>Không hoạt động</option>
                        </select>
                    </div>
                    
                    <div class="mb-3">
                        <label for="department" class="form-label">Phòng Ban</label>
                        <select class="form-select" id="department" name="department.id">
                            <option value="">Chọn phòng ban</option>
                            <c:forEach var="dept" items="${departments}">
                                <option value="${dept.id}" 
                                    <c:if test="${employee.department != null && employee.department.id == dept.id}">selected</c:if>>
                                    ${dept.name}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <button type="submit" class="btn btn-primary">
                        <c:if test="${employee.id != null}">Cập Nhật</c:if>
                        <c:if test="${employee.id == null}">Thêm Mới</c:if>
                    </button>
                    <a href="/employees" class="btn btn-secondary">Hủy</a>
                </form>
            </div>
        </div>
    </div>
</body>
</html>