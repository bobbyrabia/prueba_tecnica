package com.enterprises.enterprises.controller;

import com.enterprises.enterprises.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enterprise")
@CrossOrigin("http://localhost:4200")
public class DepartmentsController {
    @Autowired
    private DepartmentService departmentService;

}
