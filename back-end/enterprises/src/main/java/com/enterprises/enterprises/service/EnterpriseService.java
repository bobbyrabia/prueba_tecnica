package com.enterprises.enterprises.service;

import com.enterprises.enterprises.model.Departments;
import com.enterprises.enterprises.model.Enterprise;
import com.enterprises.enterprises.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EnterpriseService {
    @Autowired
    EnterpriseRepository enterpriseRepository;

    public Enterprise createEnterprise(Enterprise enterprise){
        enterprise.setStatus(true);
        enterprise.setCreated_by("usuario 1");
        Date fecha=new Date();
        enterprise.setCreated_date(fecha);
        return enterpriseRepository.save(enterprise);
    }

    public int editEnterprise(Integer id, Enterprise enterprise){
        enterprise.setStatus(true);
        enterprise.setModified_by("usuario 2");
        Date fecha=new Date();
        enterprise.setModified_date(fecha);
        System.out.println(enterprise.getModified_by()+" "+enterprise.getModified_date());
        return enterpriseRepository.updateEnterpriseById(enterprise.getAddress(),enterprise.getModified_by(), enterprise.getModified_date(), enterprise.getName(), enterprise.getPhone(),id);
    }
    public Enterprise findEnterpriseById(Integer id){
        return enterpriseRepository.getEnterpriseByIdAAndStatus(id);
    }

    public List<Enterprise> listEnterprise(){
        return enterpriseRepository.getEnterpriseByStatus();

    }
}
