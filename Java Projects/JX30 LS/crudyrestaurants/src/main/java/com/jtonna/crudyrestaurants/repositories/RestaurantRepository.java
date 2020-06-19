package com.jtonna.crudyrestaurants.repositories;

import com.jtonna.crudyrestaurants.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository
        extends CrudRepository<Restaurant, Long>
{

}
