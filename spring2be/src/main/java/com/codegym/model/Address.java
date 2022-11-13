package com.codegym.model;

import javax.persistence.*;

@Table
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(200)")
    private String street;

    @ManyToOne
    @JoinColumn(name = "province_id",referencedColumnName = "id")
    private Province province;
}
