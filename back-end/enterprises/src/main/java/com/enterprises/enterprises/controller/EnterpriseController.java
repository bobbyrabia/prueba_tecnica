package com.enterprises.enterprises.controller;

import com.enterprises.enterprises.model.Enterprise;
import com.enterprises.enterprises.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
@CrossOrigin("http://localhost:4200")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/enterprise-listar")
    List<Enterprise>listaEnterprise(){return enterpriseService.listEnterprise();}



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/enterprise-create")
    Enterprise createEnterprise(@RequestBody Enterprise enterprise){
        return enterpriseService.createEnterprise(enterprise);
    }
    @PutMapping("/enterprise-edit/{id}")
    int enterpriseEdit(@PathVariable Integer id,@RequestBody Enterprise enterprise){
        try{
            return enterpriseService.editEnterprise(id, enterprise);
        }catch (Exception e){
            System.out.println("Exception "+e);
            return 0;
        }


    }






}
