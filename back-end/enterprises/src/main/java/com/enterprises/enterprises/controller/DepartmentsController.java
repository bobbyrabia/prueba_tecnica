package com.enterprises.enterprises.controller;

import com.enterprises.enterprises.model.Departments;
import com.enterprises.enterprises.model.Enterprise;
import com.enterprises.enterprises.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin("http://localhost:4200")
public class DepartmentsController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department-listar")
    List<Departments> listaDepartments(){return departmentService.listDepartments();}


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/department-create")
    Departments createDepartments(@RequestBody Departments departments){
        return departmentService.createDepartment(departments);

    }
    @PutMapping("/department-edit/{id}")
    int departmentEdit(@PathVariable Integer id,@RequestBody Departments departments){
        try{
            return departmentService.editDepartments(id,departments);

        }catch (Exception e){
            System.out.println("Exception "+e);
            return 0;
        }


    }


}
