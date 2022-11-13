package com.codegym.model;

import javax.persistence.*;

@Table
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private String email;

    @OneToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;
}
