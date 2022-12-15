package com.enterprises.enterprises.repository;

import com.enterprises.enterprises.model.Departments;
import com.enterprises.enterprises.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Integer> {
    @Query("select e from Enterprise e where e.id = ?1 and e.status=true")
    Enterprise getEnterpriseByIdAAndStatus(Integer id);
    @Query("select e from Enterprise e where e.status = true")
    List<Enterprise> getEnterpriseByStatus();
    List<Enterprise> findByName(String Name);
    @Query("select e from Enterprise e where e.id = ?1")
    Enterprise getEnterpriseById(Integer id);


    @Modifying
    @Transactional
    @Query(
            value="update enterprise set address=?1,modified_by=?2,modified_date=?3,name=?4, phone=?5 where id=?6",
            nativeQuery=true
    )
    int updateEnterpriseById(String address, String modified_by,Date modified_date, String name, String phone, Integer id);

}
