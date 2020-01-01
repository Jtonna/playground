package com.jtonna.crudrestaurants.crudrestaurants.models;

import javax.persistence.*;

@Entity
@Table(name = "menus")
public class Menu {

    // Private ID primarily used for relationship mapping in join tables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuid;

    // fields for various values
    @Column(unique = true, nullable = false)
    private String dishname;

    @Column(unique = true, nullable = false)
    private String dishdescription;

    @Column(unique = true, nullable = false)
    private double dishprice;

    // Relationship between Restaurant Model
    // Since there are are going to be many "menu" to one restaurant, where a menu represents a menu item.
    @ManyToOne
    @JoinColumn(name = "restaurantid", nullable = false)
    private Restaurant restaurant;

}
