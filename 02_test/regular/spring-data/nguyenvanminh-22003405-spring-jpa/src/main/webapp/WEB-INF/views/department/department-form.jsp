<%@page contentType="text/html" pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Form Phòng Ban</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="container mt-4">
      <div class="row">
        <div class="col-12">
          <h2>
            <c:if test="${department.id != null}">Cập Nhật Phòng Ban</c:if>
            <c:if test="${department.id == null}">Thêm Phòng Ban Mới</c:if>
          </h2>
          <a href="/departments" class="btn btn-secondary mb-3">Quay lại</a>

          <form
            method="POST"
            action="<c:if test='${department.id != null}'>/departments/${department.id}</c:if><c:if test='${department.id == null}'>/departments</c:if>"
          >
            <div class="mb-3">
              <label for="name" class="form-label">Tên Phòng Ban</label>
              <input
                type="text"
                class="form-control"
                id="name"
                name="name"
                value="${department.name}"
                required
                placeholder="Nhập tên phòng ban"
              />
            </div>

            <button type="submit" class="btn btn-primary">
              <c:if test="${department.id != null}">Cập Nhật</c:if>
              <c:if test="${department.id == null}">Thêm Mới</c:if>
            </button>
            <a href="/departments" class="btn btn-secondary">Hủy</a>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
