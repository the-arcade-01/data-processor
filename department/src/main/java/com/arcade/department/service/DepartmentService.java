package com.arcade.department.service;

import com.arcade.department.entity.Department;
import com.arcade.department.repository.DepartmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public Department saveDepartment(Department department) {
        log.info("Service : save department");
        return departmentRepo.save(department);
    }

    public Department findByDepartmentId(Long id) {
        log.info("Service : find department by id");
        return departmentRepo.findByDepartmentId(id);
    }
}
