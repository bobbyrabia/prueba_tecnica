package com.enterprises.enterprises.repository;

import com.enterprises.enterprises.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Integer> {
    @Query("select d from Departments d where d.status = true")
    List<Departments> getDepartmentsByStatus();

    @Modifying
    @Transactional
    @Query(
            value="update departments set name=?1, phone=?2, id_enterprise=?3 where id=?4",
            nativeQuery=true
    )
    int updateDepartmentsById(String name, String phone,Integer id_enterprise, Integer id);
}
