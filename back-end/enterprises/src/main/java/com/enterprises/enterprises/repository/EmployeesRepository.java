package com.enterprises.enterprises.repository;

import com.enterprises.enterprises.model.Departments;
import com.enterprises.enterprises.model.Employees;
import com.enterprises.enterprises.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    @Query("select e from Employees e where e.status = true")
    List<Employees> getEmployeesByStatus();

    @Modifying
    @Transactional
    @Query(
            value="update employees set name=?1, position=?2, surname=?3 where id=?4",
            nativeQuery=true
    )
    int updateEmployeeById(String name, String position, String surname, Integer id);


}
