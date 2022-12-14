package com.enterprises.enterprises.repository;

import com.enterprises.enterprises.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Integer> {
    List<Enterprise> findByName(String Name);
    @Query("select e from Enterprise e where e.id = ?1")
    Enterprise getEnterpriseById(Integer id);

    @Modifying
    @Transactional
    @Query(
            value="update enterprise set name=?1, phone=?2 where id=?3",
            nativeQuery=true
    )
    int updateEnterpriseById(String name, String phone, Integer id);


}
