package com.jin.entity.repository;

import com.jin.entity.Department;
import com.jin.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {

    @Autowired
    private DepartmentRepository departmentRepository;

    private final Map<Integer, Employee> employeesById;

    public EmployeeRepository() {
        employeesById = new LinkedHashMap<>();
        employeesById.put(1, new Employee(1, "张三", "zhansan@test.com", 1, new Department(101, "教学部")));
        employeesById.put(2, new Employee(2, "李四", "lisi@test.com", 0, new Department(102, "市场部")));
        employeesById.put(3, new Employee(3, "王五", "wangwu@test.com", 0, new Department(103, "运营部")));
        employeesById.put(4, new Employee(4, "赵六", "zhaoliu@test.com", 1, new Department(104, "后勤部")));
    }

    private static Integer initId = 5;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        Department department = departmentRepository.getDepartmentById(employee.getDepartment().getId());
        employee.setDepartment(department);
        employeesById.put(employee.getId(), employee);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employeesById.values());
    }

    public Employee getEmployeeById(Integer id) {
        return employeesById.get(id);
    }

    public void deleteById(Integer id) {
        employeesById.remove(id);
    }
}
