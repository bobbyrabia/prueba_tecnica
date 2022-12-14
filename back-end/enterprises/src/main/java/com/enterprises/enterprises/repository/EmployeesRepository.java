package com.enterprises.enterprises.repository;

import com.enterprises.enterprises.model.Departments;
import com.enterprises.enterprises.model.Employees;
import com.enterprises.enterprises.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    @Query("select e from Employees e where e.status = true")
    List<Employees> getEmployeesByStatus();

    @Modifying
    @Transactional
    @Query(
            value="update employees set age=?1, email=?2 ,modified_by=?3, modified_date=?4, name=?5, position=?6, surname=?7 where id=?8",
            nativeQuery=true
    )
    int updateEmployeeById(Integer age, String email, String modified_by, Date modified_date,String name, String position, String surname, Integer id);


}
