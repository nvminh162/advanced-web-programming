// ❌ DEMO: Nếu xóa constructor
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final JdbcTemplate jdbcTemplate; // ❌ Không được khởi tạo!

    // ❌ Không có constructor với DataSource
    // Spring không biết cách tạo JdbcTemplate

    @Override
    public List<Employee> findAll() {
        // ❌ NullPointerException vì jdbcTemplate = null
        return jdbcTemplate.query(sql, rowMapper);
    }
}

// 🔥 KẾT QUẢ:
// 1. Compile error: final field jdbcTemplate not initialized
// 2. Hoặc nếu không final: NullPointerException at runtime
// 3. Spring không thể inject DataSource vào jdbcTemplate