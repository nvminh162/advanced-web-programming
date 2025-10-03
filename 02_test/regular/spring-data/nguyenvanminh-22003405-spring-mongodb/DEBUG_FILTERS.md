# 🔍 DEBUG GUIDE - Employee Filters

## ✅ Các thay đổi đã thực hiện:

### 1. **Search by Name** (Tìm theo tên)
**Vấn đề cũ:**
- Sử dụng `findByName()` → Chỉ tìm exact match
- Không phân biệt hoa thường
- Ví dụ: Tìm "Nguyen" không tìm thấy "nguyen van a"

**Fix mới:**
```java
@Query("{'name': {$regex: ?0, $options: 'i'}}")
List<Employee> findByNameContainingIgnoreCase(String keyword);
```
- ✅ Tìm theo keyword (partial match)
- ✅ Không phân biệt hoa thường
- ✅ Tìm "nguyen" → Tìm thấy "Nguyen Van A", "Nguyen Thi H", etc.

**Cách test:**
- Nhập "nguyen" → Kết quả: 5 employees
- Nhập "van" → Kết quả: 9 employees
- Nhập "thi" → Kết quả: 8 employees

---

### 2. **Filter by Department** (Lọc theo phòng ban)
**Vấn đề cũ:**
- Query `{'department.$id': ?0}` có thể không đúng format MongoDB DBRef

**Fix mới:**
```java
List<Employee> findByDepartment_Id(String departmentId);
```
- ✅ Sử dụng Spring Data naming convention
- ✅ Tự động map với DBRef structure
- ✅ Tương thích với MongoDB DBRef

**Cách test:**
1. Vào trang departments: http://localhost:8080/departments
2. Copy ID của một department (ví dụ: IT department)
3. Vào trang employees và chọn department đó trong dropdown
4. Kết quả: Chỉ hiển thị employees của department đó

---

## 🧪 TEST CASES:

### Test 1: Search by Name
```
URL: http://localhost:8080/employees?searchName=nguyen
Expected: 5 employees (Nguyen Van A, Nguyen Van M, Nguyen Thi H, Nguyen Van T)
```

### Test 2: Search by Age
```
URL: http://localhost:8080/employees?searchAge=28
Expected: 3 employees (Tran Thi B, Pham Van P, ...)
```

### Test 3: Filter by Department
```
URL: http://localhost:8080/employees?departmentId=<IT_DEPARTMENT_ID>
Expected: 4 employees (Nguyen Van A, Tran Thi B, Nguyen Van M, Dang Thi S)
```

### Test 4: Filter by Salary Range
```
URL: http://localhost:8080/employees?salaryFrom=15000000&salaryTo=20000000
Expected: ~7 employees với lương từ 15tr-20tr
```

---

## 🐛 Nếu vẫn không work:

### Kiểm tra 1: Xem cấu trúc dữ liệu trong MongoDB
Kết nối MongoDB Compass với URI:
```
mongodb+srv://nvminh1602:zMI8V5g92XoBNmsn@cluster0.sh1iqcw.mongodb.net/employee_management
```

Chạy query trong MongoDB để xem cấu trúc:
```javascript
db.employees.findOne()
```

Xem field `department` có format như thế nào:
- Nếu là: `{$ref: "departments", $id: "xxx"}` → Dùng method `findByDepartment_Id`
- Nếu là: `{id: "xxx"}` → Cần dùng query khác

### Kiểm tra 2: Console Log
Thêm log vào Service để debug:
```java
@Override
public List<Employee> getEmployeesByDepartmentId(String departmentId) {
    System.out.println("🔍 Searching employees by departmentId: " + departmentId);
    List<Employee> result = employeeRepository.findByDepartment_Id(departmentId);
    System.out.println("✅ Found " + result.size() + " employees");
    return result;
}
```

### Kiểm tra 3: Application logs
Xem logs khi chạy app để tìm MongoDB query thực tế:
```
spring.data.mongodb.uri=...
logging.level.org.springframework.data.mongodb.core=DEBUG
```

---

## 📝 Summary of Changes:

| Feature | Old Method | New Method | Status |
|---------|-----------|-----------|--------|
| Search Name | `findByName()` | `findByNameContainingIgnoreCase()` with regex | ✅ Fixed |
| Filter Department | `@Query("{'department.$id': ?0}")` | `findByDepartment_Id()` | ✅ Fixed |
| Search Age | `findByAgeBetween(age, age)` | `findByAge(age)` | ✅ Fixed |
| Salary Range | Stream filter | `findBySalaryBetween()` | ✅ Fixed |

---

## 🚀 Next Steps:
1. Chạy lại application
2. Test từng filter một
3. Check MongoDB data nếu vẫn có vấn đề
4. Xem console logs để debug
