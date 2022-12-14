package com.enterprises.enterprises.repository;

import com.enterprises.enterprises.model.Department_employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Department_employeesRepository extends JpaRepository<Department_employees,Integer> {

}
