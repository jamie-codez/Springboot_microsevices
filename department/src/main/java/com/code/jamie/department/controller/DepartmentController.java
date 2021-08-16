package com.code.jamie.department.controller;

import com.code.jamie.department.entities.Department;
import com.code.jamie.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/")
    public Department createDepartment(@RequestBody Department department){
        log.info("Inside createDepartment of "+getClass().getName());
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable(name = "id") Long departmentId){
        log.info("Inside findDepartmentById method of "+getClass().getName());
        return  departmentService.findDepartmentById(departmentId);
    }
}
