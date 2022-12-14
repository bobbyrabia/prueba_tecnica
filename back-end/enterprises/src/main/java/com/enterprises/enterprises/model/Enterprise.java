package com.enterprises.enterprises.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enterprise {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String created_by;
    private Date created_date;
    private String modified_by;
    private Date modified_date;
    private Boolean status;
    private String address;
    private String name;
    private String phone;
}
