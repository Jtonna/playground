package com.jtonna.crudrestaurants.crudrestaurants.models;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    // Generated ID primarily used for mapping
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurantid;

    // fields
    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String address;

    @Column(unique = true, nullable = false)
    private String city;

    @Column(unique = true, nullable = false)
    private String state;

    @Column(unique = true, nullable = false)
    private String telephone;

    // Relationship between Menu Model


}
