package com.jtonna.crudyrestaurants.controllers;

import com.jtonna.crudyrestaurants.models.Restaurant;
import com.jtonna.crudyrestaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController
{
    // We need to bring the service to get the data for us
    @Autowired
    RestaurantService restaurantService;

    // http://localhost:2019/restaurants/restaurant/3
    @GetMapping(value = "/restaurant/{id}", produces = {"application/json"})
    public ResponseEntity<?> findRestaurantById(@PathVariable long id)
    {
        Restaurant r = restaurantService.findRestaurantById(id);

        return new ResponseEntity<>(r ,HttpStatus.OK);
    }


    // http://localhost:2019/restaurants/restaurants
    @GetMapping(value = "/restaurants", produces = {"application/json"})
    public ResponseEntity<?> listAllRestaurants()
    {
        List<Restaurant> theRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(theRestaurants, HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/restaurant/likename/eat
    @GetMapping(value = "/restaurants/likename/{name}")
    public ResponseEntity<?> listAllRestaurantsLikeName(String name)
    {
        List<Restaurant> myRestaurants = restaurantService.findByNameLike(name);

        return new ResponseEntity<>(myRestaurants, HttpStatus.OK);
    }
}
