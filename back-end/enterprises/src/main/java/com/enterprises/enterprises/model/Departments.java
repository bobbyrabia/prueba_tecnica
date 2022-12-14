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
public class Departments {
   @Id @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String created_by;
    private Date created_date;
    private String modified_by;
    private Date modified_date;
    private Boolean status;
    private String description;
    private String name;
    private String phone;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "id_enterprise",
            referencedColumnName = "id"
    )
    private Enterprise id_enterprise;

}
