package com.enterprises.enterprises.service;

import com.enterprises.enterprises.model.Departments;
import com.enterprises.enterprises.model.Enterprise;
import com.enterprises.enterprises.repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentsRepository departmentsRepository;
    @Autowired
    EnterpriseService enterpriseService;

    public Departments createDepartment(Departments departments){
        Enterprise enterprise_temp=enterpriseService.findEnterpriseById(departments.getId_enterprise().getId());
        departments.setId_enterprise(enterprise_temp);
        departments.setStatus(true);
        departments.setCreated_by("usuario 1");
        Date fecha=new Date();
        departments.setCreated_date(fecha);
        return departmentsRepository.save(departments);
    }

    public int editDepartments(Integer id, Departments departments){
        return  departmentsRepository.updateDepartmentsById(departments.getModified_by(),departments.getModified_date(),departments.getDescription(),departments.getName(),departments.getPhone(),departments.getId_enterprise().getId(),id);
    }
    public List<Departments> listDepartments(){
        return departmentsRepository.getDepartmentsByStatus();
    }




}
