package com.enterprises.enterprises.controller;

import com.enterprises.enterprises.model.Employees;
import com.enterprises.enterprises.model.Enterprise;
import com.enterprises.enterprises.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employeer")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees-listar")
    List<Employees> listaEmployees(){return employeeService.listEmployees();}
}
