package com.jtonna.crudyrestaurants.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payments")
public class Payment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentid;

    @Column(nullable = false, unique = true)
    private String type; // Payment Type

    @ManyToMany(mappedBy = "payments")
    private List<Restaurant> restaurants = new ArrayList<>();
}
