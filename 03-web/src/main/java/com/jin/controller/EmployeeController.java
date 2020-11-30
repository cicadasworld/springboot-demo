package com.jin.controller;

import com.jin.entity.Department;
import com.jin.entity.Employee;
import com.jin.entity.repository.DepartmentRepository;
import com.jin.entity.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping("/emps")
    public String list(Model model) {
        List<Employee> employees = employeeRepository.getEmployees();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        List<Department> departments = departmentRepository.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeRepository.getEmployeeById(id);
        model.addAttribute("emp", employee);
        List<Department> departments = departmentRepository.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/update";
    }

    @PostMapping("/emp/update")
    public String updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/emps";
    }


    @GetMapping("/delemp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeRepository.deleteById(id);
        return "redirect:/emps";
    }
}
