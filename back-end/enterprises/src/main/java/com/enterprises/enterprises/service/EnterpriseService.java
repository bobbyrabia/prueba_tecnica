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
        return enterpriseRepository.save(enterprise);
    }

    public int editEnterprise(Integer id, Enterprise enterprise){
        return enterpriseRepository.updateEnterpriseById(enterprise.getAddress(),enterprise.getModified_by(), enterprise.getModified_date(), enterprise.getName(), enterprise.getPhone(),id);
    }

    public List<Enterprise> listEnterprise(){
        return enterpriseRepository.getEnterpriseByStatus();

    }
}
