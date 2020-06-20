package com.jtonna.crudyrestaurants.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity // Defines this as a Table (but in relational algebra we call them entity)
@Table( name = "menus") // Plural because it holds information about not just one restaurant, but multiple

// It may seem confusing but this defines an individual Menu Item, we are just calling it menu.
public class Menu
{
    // This will be out Unique ID (primary key)
    @Id // defines it as an id
    @GeneratedValue(strategy = GenerationType.AUTO) // We done care what it is or how its set, it just needs to be unique
    private long menuid;

    @Column(nullable = false) // makes this column in the table impossible to be null
    private String dish;

    private double price;

    // Because Restaurant contains a List of Menu (items), We must contain a Restaurant (Many to one relationship)
    // So basically this menu can only go to one Restaurant, but a Restaurant can have many menu items's
    @ManyToOne // Defines the relationship
    @JoinColumn( name = "restaurantid", nullable = false) // How we join the two in a join table
    @JsonIgnoreProperties(value = "menus") // ignore the model's table name we are in because of infinite loops
    private Restaurant restaurant;

    public Menu()
    {
    }

    public Menu(String dish, double price, Restaurant restaurant)
    {
        this.dish = dish;
        this.price = price;
        this.restaurant = restaurant;
    }

    public long getMenuid()
    {
        return menuid;
    }

    public void setMenuid(long menuid)
    {
        this.menuid = menuid;
    }

    public String getDish()
    {
        return dish;
    }

    public void setDish(String dish)
    {
        this.dish = dish;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Restaurant getRestaurant()
    {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant)
    {
        this.restaurant = restaurant;
    }

    @Override
    public String toString()
    {
        return "Menu{" + "menuid=" + menuid + ", dish='" + dish + '\'' + ", price=" + price + ", restaurant=" + restaurant + '}';
    }
}
