package com.jtonna.crudyrestaurants.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // Defines this as a Table (but in relational algebra we call them entity)
@Table( name = "restaurants") // Plural because it holds information about not just one restaurant, but multiple
public class Restaurant
{
    // This will be out Unique ID (primary key)
    @Id // defines it as an id
    @GeneratedValue(strategy = GenerationType.AUTO) // We done care what it is or how its set, it just needs to be unique
    private long restaurantid;

    @Column(nullable = false, unique = true) // This makes it so the name column cant be null & no one else can have that name
    private String name;

    private String address, city, state, telephone;
    private int seatingcapacity;

    // This table will contain the list of menu items for the restaurant
    @OneToMany(mappedBy = "restaurant", // mapped by the field listed in restaurant
            cascade = CascadeType.ALL, // changes made to restaurant cascade to the menus (lise a restaurant name changing, or deleting a restaurant
            orphanRemoval = true) // if for some reason a menu is found without a restaurant, we remove it.
    @JsonIgnoreProperties(value = "restaurant") // ignore the model's name we are in because of infinite loops
    private List<Menu> menus = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "restaurantpayments", // name of the table
            joinColumns = @JoinColumn(name = "restaurantid"), // One part of the Join Table
            inverseJoinColumns = @JoinColumn(name = "paymentid")) // The other part of the Join Table
    @JsonIgnoreProperties(value = "restaurants") // ignore the model's table we are in because of infinite loops
    private List<Payment> payments = new ArrayList<>();

    public Restaurant()
    {
    }

    public Restaurant(String name, String address, String city, String state, String telephone, int seatingcapacity)
    {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.telephone = telephone;
        this.seatingcapacity = seatingcapacity;
    }

    public long getRestaurantid()
    {
        return restaurantid;
    }

    public void setRestaurantid(long restaurantid)
    {
        this.restaurantid = restaurantid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public int getSeatingcapacity()
    {
        return seatingcapacity;
    }

    public void setSeatingcapacity(int seatingcapacity)
    {
        this.seatingcapacity = seatingcapacity;
    }

    public List<Menu> getMenus()
    {
        return menus;
    }

    public void setMenus(List<Menu> menus)
    {
        this.menus = menus;
    }

    public List<Payment> getPayments()
    {
        return payments;
    }

    public void setPayments(List<Payment> payments)
    {
        this.payments = payments;
    }

    @Override
    public String toString()
    {
        return "Restaurant{" + "restaurantid=" + restaurantid + ", name='" + name + '\'' + ", address='" + address + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", telephone='" + telephone + '\'' + ", seatingcapacity=" + seatingcapacity + ", menus=" + menus + ", payments=" + payments + '}';
    }
}
