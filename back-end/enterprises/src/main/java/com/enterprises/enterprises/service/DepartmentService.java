package com.enterprises.enterprises.service;

import com.enterprises.enterprises.model.Departments;
import com.enterprises.enterprises.model.Enterprise;
import com.enterprises.enterprises.repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentsRepository departmentsRepository;

    public Departments createDepartment(Departments departments){
        return departmentsRepository.save(departments);

    }

    public int editDepartments(Integer id, Departments departments){
        return  departmentsRepository.updateDepartmentsById(departments.getModified_by(),departments.getModified_date(),departments.getDescription(),departments.getName(),departments.getPhone(),departments.getId_enterprise().getId(),id);
    }
    public List<Departments> listDepartments(){
        return departmentsRepository.getDepartmentsByStatus();
    }




}
