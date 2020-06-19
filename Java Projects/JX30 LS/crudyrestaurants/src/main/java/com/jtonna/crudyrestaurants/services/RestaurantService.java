package com.jtonna.crudyrestaurants.services;

import com.jtonna.crudyrestaurants.models.Restaurant;

import java.util.List;

// List the things clients can do
public interface RestaurantService
{
    List<Restaurant> findAllRestaurants();

    Restaurant findRestaurantById(long id);

    List<Restaurant> findByNameLike();
}
