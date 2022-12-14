package com.enterprises.enterprises.controller;

import com.enterprises.enterprises.model.Departments;
import com.enterprises.enterprises.model.Enterprise;
import com.enterprises.enterprises.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin("http://localhost:4200")
public class DepartmentsController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department-listar")
    List<Departments> listaDepartments(){return departmentService.listDepartments();}
}
