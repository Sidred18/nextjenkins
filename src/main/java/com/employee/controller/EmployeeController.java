package com.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.bean.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController() {
        this.employeeService = new EmployeeService();
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{empCode}")
    public Employee getEmployeeByCode(@PathVariable int empCode) {
        return employeeService.getEmployeeByCode(empCode);
    }
    @PutMapping("/{empCode}")
    public String updateEmployee(@PathVariable int empCode,@RequestParam String empName,@RequestParam double salary) {
        return employeeService.updateEmployee(empCode, empName, salary);
    }

    @DeleteMapping("/{empCode}")
    public String deleteEmployee(@PathVariable int empCode) {
        return employeeService.deleteEmployee(empCode);
    }
}