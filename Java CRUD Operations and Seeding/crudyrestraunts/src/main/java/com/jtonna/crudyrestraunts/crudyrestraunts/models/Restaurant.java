package com.jtonna.crudyrestraunts.crudyrestraunts.models;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurantid;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(unique = true, nullable = false)
    private String telephone;


}
