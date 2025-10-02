# Spring JDBC Demo

Ứng dụng đơn giản sử dụng Spring JDBC Template để thao tác với MariaDB.

## Cấu trúc Project

```
src/main/java/com/nvminh162/springjdbcdemo/
├── SpringJdbcDemoApplication.java      # Main class
├── model/
│   └── Employee.java                   # Entity
├── dao/
│   ├── EmployeeDAO.java               # DAO interface
│   └── impl/EmployeeDAOImpl.java      # DAO implementation
├── service/
│   ├── EmployeeService.java           # Service interface
│   └── impl/EmployeeServiceImpl.java  # Service implementation
├── controller/
│   └── EmployeeController.java        # REST Controller
└── exception/
    └── GlobalExceptionHandler.java   # Exception handler
```

## Cách chạy

### 1. Chuẩn bị Database
Chạy file SQL trước khi start project:
```bash
mysql -u root -p -P 3307 < database/init.sql
```

### 2. Chạy ứng dụng
```bash
./mvnw spring-boot:run
```

### 3. Test API
```bash
# Lấy tất cả employees
curl http://localhost:8080/api/employees

# Lấy employee theo ID
curl http://localhost:8080/api/employees/1

# Tạo mới
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{"name": "Nguyen Van Test", "role": "Developer"}'

# Cập nhật
curl -X PUT http://localhost:8080/api/employees/1 \
  -H "Content-Type: application/json" \
  -d '{"name": "Updated Name", "role": "Manager"}'

# Xóa
curl -X DELETE http://localhost:8080/api/employees/1
```

## Database Configuration
```properties
spring.datasource.url=jdbc:mariadb://localhost:3307/www_spring_jdbc_demo
spring.datasource.username=root
spring.datasource.password=root
```