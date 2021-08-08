package com.upgrad.springbootdemo.service;

import com.upgrad.springbootdemo.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getDepartments();
    Department getDepartmentById(Long departmentId);
    void deleteDepartmentById(Long departmentId);
    Department updateDepartment(Long departmentId, Department department);
}
