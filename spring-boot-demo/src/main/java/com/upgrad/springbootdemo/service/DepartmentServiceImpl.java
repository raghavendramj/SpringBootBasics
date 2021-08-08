package com.upgrad.springbootdemo.service;

import com.upgrad.springbootdemo.entity.Department;
import com.upgrad.springbootdemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

        if (departmentRepository.findById(departmentId).isPresent()) {
            Department departmentFromDB = departmentRepository.findById(departmentId).get();

            if (Objects.nonNull(departmentFromDB.getDepartmentName()) && !"".equalsIgnoreCase((departmentFromDB.getDepartmentName()))) {
                departmentFromDB.setDepartmentName(department.getDepartmentName());
            }

            if (Objects.nonNull(departmentFromDB.getDepartmentAddress()) && !"".equalsIgnoreCase((departmentFromDB.getDepartmentAddress()))) {
                departmentFromDB.setDepartmentAddress(department.getDepartmentAddress());
            }
            if (Objects.nonNull(departmentFromDB.getDepartmentCode()) && !"".equalsIgnoreCase((departmentFromDB.getDepartmentCode()))) {
                departmentFromDB.setDepartmentCode(department.getDepartmentCode());
            }
            return departmentRepository.save(departmentFromDB);
        }
        return null;
    }
}
