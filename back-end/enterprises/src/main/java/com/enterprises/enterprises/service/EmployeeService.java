package com.enterprises.enterprises.service;

import com.enterprises.enterprises.model.Departments;
import com.enterprises.enterprises.model.Employees;
import com.enterprises.enterprises.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeesRepository employeesRepository;

    public Employees createEmployees(Employees employees){
        employees.setStatus(true);
        employees.setCreated_by("usuario 1");
        Date fecha=new Date();
        employees.setCreated_date(fecha);
        return employeesRepository.save(employees);
    }
    public Employees findEmployeeById(Integer id){
        return employeesRepository.getEmployeesByIdAndStatus(id);
    }

    public int editEmployees(Integer id, Employees employees){
        employees.setStatus(true);
        employees.setModified_by("usuario 2");
        Date fecha=new Date();
        employees.setModified_date(fecha);
        System.out.println(employees.getModified_by()+" "+employees.getModified_date());
        return employeesRepository.updateEmployeeById(employees.getAge(),employees.getEmail(),employees.getModified_by(),employees.getModified_date(),employees.getName(),employees.getPosition(),employees.getSurname(),id);
    }
    public List<Employees> listEmployees(){
        return employeesRepository.getEmployeesByStatus();
    }
}

