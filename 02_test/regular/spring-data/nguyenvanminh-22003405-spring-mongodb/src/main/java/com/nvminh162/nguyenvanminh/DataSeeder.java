package com.nvminh162.nguyenvanminh;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nvminh162.nguyenvanminh.model.Department;
import com.nvminh162.nguyenvanminh.model.Employee;
import com.nvminh162.nguyenvanminh.repository.DepartmentRepository;
import com.nvminh162.nguyenvanminh.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

        private final DepartmentRepository departmentRepo;
        private final EmployeeRepository employeeRepo;

        @Override
        public void run(String... args) throws Exception {
                if (departmentRepo.count() == 0 && employeeRepo.count() == 0) {
                        seedData();
                }
        }

        private void seedData() {
                Department it = departmentRepo.save(Department.builder()
                                .name("IT")
                                .build());

                Department hr = departmentRepo.save(Department.builder()
                                .name("HR")
                                .build());

                Department finance = departmentRepo.save(Department.builder()
                                .name("Finance")
                                .build());

                Department marketing = departmentRepo.save(Department.builder()
                                .name("Marketing")
                                .build());

                Department sales = departmentRepo.save(Department.builder()
                                .name("Sales")
                                .build());

                Department operations = departmentRepo.save(Department.builder()
                                .name("Operations")
                                .build());

                List<Employee> employees = List.of(
                                Employee.builder()
                                                .name("Nguyen Van A")
                                                .email("nguyenvana@company.com")
                                                .age(25)
                                                .salary(12000000)
                                                .status(1)
                                                .department(it)
                                                .build(),

                                Employee.builder()
                                                .name("Tran Thi B")
                                                .email("tranthib@company.com")
                                                .age(28)
                                                .salary(15000000)
                                                .status(1)
                                                .department(it)
                                                .build(),

                                Employee.builder()
                                                .name("Le Van C")
                                                .email("levanc@company.com")
                                                .age(30)
                                                .salary(10000000)
                                                .status(1)
                                                .department(hr)
                                                .build(),

                                Employee.builder()
                                                .name("Pham Thi D")
                                                .email("phamthid@company.com")
                                                .age(27)
                                                .salary(18000000)
                                                .status(1)
                                                .department(hr)
                                                .build(),

                                Employee.builder()
                                                .name("Hoang Van E")
                                                .email("hoangvane@company.com")
                                                .age(35)
                                                .salary(25000000)
                                                .status(1)
                                                .department(finance)
                                                .build(),

                                Employee.builder()
                                                .name("Vo Thi F")
                                                .email("vothif@company.com")
                                                .age(29)
                                                .salary(23000000)
                                                .status(1)
                                                .department(finance)
                                                .build(),

                                Employee.builder()
                                                .name("Dang Van G")
                                                .email("dangvang@company.com")
                                                .age(32)
                                                .salary(21000000)
                                                .status(1)
                                                .department(marketing)
                                                .build(),

                                Employee.builder()
                                                .name("Nguyen Thi H")
                                                .email("nguyenthih@company.com")
                                                .age(26)
                                                .salary(19500000)
                                                .status(1)
                                                .department(marketing)
                                                .build(),

                                Employee.builder()
                                                .name("Phan Van I")
                                                .email("phanvani@company.com")
                                                .age(31)
                                                .salary(17000000)
                                                .status(1)
                                                .department(sales)
                                                .build(),

                                Employee.builder()
                                                .name("Bui Thi J")
                                                .email("buithij@company.com")
                                                .age(24)
                                                .salary(16000000)
                                                .status(1)
                                                .department(sales)
                                                .build(),

                                Employee.builder()
                                                .name("Do Van K")
                                                .email("dovank@company.com")
                                                .age(40)
                                                .salary(28000000)
                                                .status(1)
                                                .department(operations)
                                                .build(),

                                Employee.builder()
                                                .name("Trinh Thi L")
                                                .email("trinhthil@company.com")
                                                .age(33)
                                                .salary(20000000)
                                                .status(1)
                                                .department(operations)
                                                .build(),

                                Employee.builder()
                                                .name("Nguyen Van M")
                                                .email("nguyenvanm@company.com")
                                                .age(22)
                                                .salary(9000000)
                                                .status(1)
                                                .department(it)
                                                .build(),

                                Employee.builder()
                                                .name("Tran Van N")
                                                .email("tranvann@company.com")
                                                .age(29)
                                                .salary(14000000)
                                                .status(1)
                                                .department(hr)
                                                .build(),

                                Employee.builder()
                                                .name("Le Thi O")
                                                .email("lethio@company.com")
                                                .age(34)
                                                .salary(22000000)
                                                .status(1)
                                                .department(finance)
                                                .build(),

                                Employee.builder()
                                                .name("Pham Van P")
                                                .email("phamvanp@company.com")
                                                .age(28)
                                                .salary(17500000)
                                                .status(1)
                                                .department(marketing)
                                                .build(),

                                Employee.builder()
                                                .name("Hoang Thi Q")
                                                .email("hoangthiq@company.com")
                                                .age(23)
                                                .salary(15500000)
                                                .status(1)
                                                .department(sales)
                                                .build(),

                                Employee.builder()
                                                .name("Vo Van R")
                                                .email("vovanr@company.com")
                                                .age(37)
                                                .salary(26000000)
                                                .status(1)
                                                .department(operations)
                                                .build(),

                                Employee.builder()
                                                .name("Dang Thi S")
                                                .email("dangthis@company.com")
                                                .age(21)
                                                .salary(11000000)
                                                .status(0)
                                                .department(it)
                                                .build(),

                                Employee.builder()
                                                .name("Nguyen Van T")
                                                .email("nguyenvant@company.com")
                                                .age(27)
                                                .salary(13500000)
                                                .status(1)
                                                .department(hr)
                                                .build());

                // Lưu tất cả nhân viên
                employeeRepo.saveAll(employees);

                System.out.println("✅ Data seeding completed successfully!");
                System.out.println("📊 Created " + departmentRepo.count() + " departments");
                System.out.println("👥 Created " + employeeRepo.count() + " employees");
        }
}
