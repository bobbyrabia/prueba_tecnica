package com.enterprises.enterprises.repository;

import com.enterprises.enterprises.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Integer> {
    @Query("select d from Departments d where d.status = true")
    List<Departments> getDepartmentsByStatus();

    @Modifying
    @Transactional
    @Query(
            value="update departments set modified_by=?1,modified_date=?2,description=?3, name=?4, phone=?5, id_enterprise=?6 where id=?7",
            nativeQuery=true
    )
    int updateDepartmentsById(String modified_by, Date modified_date,String description,String name, String phone, Integer id_enterprise, Integer id);
}
