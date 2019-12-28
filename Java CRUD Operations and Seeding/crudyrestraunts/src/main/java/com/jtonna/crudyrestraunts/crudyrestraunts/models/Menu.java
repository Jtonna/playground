package com.jtonna.crudyrestraunts.crudyrestraunts.models;

import javax.persistence.*;

@Entity
@Table(name = "menus")
public class Menu
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuid;

    @Column(nullable = false, unique = true)
    private String dishname;

    @Column(nullable = false)
    private String dishdescription;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "restaurantid", nullable = false)
    private Restaurant restaurant;

}
