package com.enterprises.enterprises.controller;

import com.enterprises.enterprises.model.Employees;
import com.enterprises.enterprises.model.Enterprise;
import com.enterprises.enterprises.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeer")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees-listar")
    List<Employees> listaEmployees(){return employeeService.listEmployees();}


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/employees-create")
    Employees createEmployee(@RequestBody Employees employee){
        return  employeeService.createEmployees(employee);

    }
    @PutMapping("/employees-edit/{id}")
    int employeeEdit(@PathVariable Integer id,@RequestBody Employees employees){
        try{
            return employeeService.editEmployees(id, employees);

        }catch (Exception e){
            System.out.println("Exception "+e);
            return 0;
        }


    }


}
