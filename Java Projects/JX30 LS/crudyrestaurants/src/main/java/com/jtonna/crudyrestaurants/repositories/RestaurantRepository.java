package com.jtonna.crudyrestaurants.repositories;

import com.jtonna.crudyrestaurants.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository
        extends CrudRepository<Restaurant, Long>
{

    // Exposing JPA Method
    // The "findByNameContainingIgnoringCase" is like a combination of built in methods | note: the IgnoringCase does not pop up while typing, but it still works.
    List<Restaurant> findByNameContainingIgnoringCase (String likename);
}
