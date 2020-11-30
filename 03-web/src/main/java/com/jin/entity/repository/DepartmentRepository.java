package com.jin.entity.repository;

import com.jin.entity.Department;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DepartmentRepository {

    private final Map<Integer, Department> departmentsById;

    public DepartmentRepository() {
        departmentsById = new LinkedHashMap<>();
        departmentsById.put(101, new Department(101, "教学部"));
        departmentsById.put(102, new Department(102, "市场部"));
        departmentsById.put(103, new Department(103, "运营部"));
        departmentsById.put(104, new Department(104, "后勤部"));
    }

    public List<Department> getDepartments() {
        return new ArrayList<>(departmentsById.values());
    }

    public Department getDepartmentById(Integer id) {
        return departmentsById.get(id);
    }
}
