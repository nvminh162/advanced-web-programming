package com.nvminh162.springjdbcdemo;

import com.nvminh162.springjdbcdemo.model.Employee;
import com.nvminh162.springjdbcdemo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.datasource.driver-class-name=org.h2.Driver"
})
class SpringJdbcDemoApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void contextLoads() {
        assertNotNull(employeeService);
    }

    @Test
    void testEmployeeService() {
        // Test save
        Employee newEmployee = new Employee("Test User", "Test Role");
        employeeService.saveEmployee(newEmployee);

        // Test getAll
        List<Employee> employees = employeeService.getAllEmployees();
        assertNotNull(employees);
        assertTrue(employees.size() > 0);

        // Test getById
        Employee firstEmployee = employees.get(0);
        Employee foundEmployee = employeeService.getEmployeeById(firstEmployee.getId());
        assertNotNull(foundEmployee);
        assertEquals(firstEmployee.getName(), foundEmployee.getName());

        // Test update
        foundEmployee.setRole("Updated Role");
        employeeService.updateEmployee(foundEmployee);
        
        Employee updatedEmployee = employeeService.getEmployeeById(foundEmployee.getId());
        assertEquals("Updated Role", updatedEmployee.getRole());

        // Test delete
        employeeService.deleteEmployeeById(foundEmployee.getId());
        Employee deletedEmployee = employeeService.getEmployeeById(foundEmployee.getId());
        assertNull(deletedEmployee);
    }
}
