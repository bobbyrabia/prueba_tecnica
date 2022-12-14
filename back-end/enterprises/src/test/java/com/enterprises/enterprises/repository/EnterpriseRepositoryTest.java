package com.enterprises.enterprises.repository;

import com.enterprises.enterprises.model.Enterprise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnterpriseRepositoryTest {
    @Autowired
    private EnterpriseRepository enterpriseRepository;
    @Test
    public void saveEnterprise(){
        Date fecha=new Date();
        Enterprise enterprise=Enterprise.builder()
                .created_by("usuario1")
                .created_date(fecha)
                .name("empresa1").build();
        enterpriseRepository.save(enterprise);
    }

    @Test
    public void updateEnterprise(){
        Integer num=2;
        Date fecha=new Date();
        enterpriseRepository.updateEnterpriseById(
                "cambio1",
                "2345616",
                num
                );
    }

}