package com.nvminh162.nguyenvanminh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nvminh162.nguyenvanminh.model.Employee;
import com.nvminh162.nguyenvanminh.service.DepartmentService;
import com.nvminh162.nguyenvanminh.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @GetMapping
    public String getAllEmployees(
            @RequestParam(value = "searchName", required = false) String searchName,
            @RequestParam(value = "searchAge", required = false) Integer searchAge,
            @RequestParam(value = "departmentId", required = false) String departmentId,
            @RequestParam(value = "salaryFrom", required = false) Double salaryFrom,
            @RequestParam(value = "salaryTo", required = false) Double salaryTo,
            Model model) {
        
        java.util.List<Employee> employees;
        
        if (searchName != null && !searchName.trim().isEmpty()) {
            employees = employeeService.getEmployeesByName(searchName.trim());
            model.addAttribute("searchName", searchName);
        } else if (searchAge != null) {
            employees = employeeService.getEmployeesByAge(searchAge);
            model.addAttribute("searchAge", searchAge);
        } else if (departmentId != null && !departmentId.trim().isEmpty()) {
            employees = employeeService.getEmployeesByDepartmentId(departmentId);
            model.addAttribute("departmentId", departmentId);
        } else if (salaryFrom != null || salaryTo != null) {
            double from = (salaryFrom != null) ? salaryFrom : 0;
            double to = (salaryTo != null) ? salaryTo : 0;
            employees = employeeService.getEmployeesBySalaryRange(from, to);
            model.addAttribute("salaryFrom", salaryFrom);
            model.addAttribute("salaryTo", salaryTo);
        } else {
            employees = employeeService.getAllEmployees();
        }
        
        model.addAttribute("employees", employees);
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employee/employee-list";
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable("id") String id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee/employee-detail";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employee/employee-form";
    }

    @PostMapping
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employee/employee-form";
    }

    @PostMapping("/{id}")
    public String updateEmployee(@PathVariable("id") String id, @ModelAttribute Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "redirect:/employees/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable("id") String id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
