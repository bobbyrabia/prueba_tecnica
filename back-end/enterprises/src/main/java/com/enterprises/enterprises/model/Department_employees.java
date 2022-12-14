package com.enterprises.enterprises.model;

import jakarta.persistence.*;
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
public class Department_employees {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String created_by;
    private Date created_date;
    private String modified_by;
    private Date modified_date;
    private Boolean status;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "id_department",
            referencedColumnName = "id"
    )
    private Departments id_department;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "id_employee",
            referencedColumnName = "id"
    )
    private Employees id_employee;
}
