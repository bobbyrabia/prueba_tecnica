package com.enterprises.enterprises.repository;

import com.enterprises.enterprises.model.Departments;
import com.enterprises.enterprises.model.Employees;
import com.enterprises.enterprises.model.Enterprise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeesRepositoryTest {
    @Autowired
    EmployeesRepository employeesRepository;

    @Test
    public void saveEmployee(){
        Date fecha=new Date();
        Employees employee=Employees.builder()
                .name("empleado2")
                .position("gerente")
                .surname("apellido2")
                .status(true)
                .build();
        employeesRepository.save(employee);


    }

    @Test
    public void printEmployees(){

        List<Employees> employeesList=employeesRepository.getEmployeesByStatus();
        System.out.println("employeesList = " + employeesList);
    }

    @Test
    public void updateEmployee(){
        Integer num=2;
        Date fecha=new Date();
        employeesRepository.updateEmployeeById(
                "cambio1",
                "conserje",
                "apellido2",
                num
                );

    }

}