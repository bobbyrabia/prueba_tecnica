package com.enterprises.enterprises.repository;

import com.enterprises.enterprises.model.Departments;
import com.enterprises.enterprises.model.Enterprise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentsRepositoryTest {
    @Autowired
    private DepartmentsRepository departmentsRepository;
    @Autowired
    private EnterpriseRepository enterpriseRepository;



    @Test
    public void saveDepartments(){
        Date fecha=new Date();
        Integer id=2;
        //Enterprise enterprise_id=enterpriseRepository.getEnterpriseById(id);
        Enterprise enterprise_id=Enterprise.builder().name("empresa5").build();
        Departments departments=Departments.builder()
                .created_by("usuario1")
                .created_date(fecha)
                .description("realiza una descripcion")
                .name("departamento1")
                .phone("123456")
                .status(true)
                .id_enterprise(enterprise_id)
                .build();
        departmentsRepository.save(departments);

        //System.out.println(departments);

    }
    @Test
    public void printDepartments(){
        Boolean status=true;
        List<Departments> departmentsList=departmentsRepository.getDepartmentsByStatus();
        System.out.println("departmentsList = " + departmentsList);
    }

    @Test
    public void updateDepartamento(){
        Integer num=2;
        Date fecha=new Date();
        Enterprise enterprise_id=Enterprise.builder().name("empresa4").build();
        departmentsRepository.updateDepartmentsById(
                "cambio2",
                "4561785",
                enterprise_id.getId(),
                num
                );
    }

}