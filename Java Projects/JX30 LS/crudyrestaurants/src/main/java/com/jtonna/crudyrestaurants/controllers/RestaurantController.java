package com.jtonna.crudyrestaurants.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController
{
    // http://localhost:2019/restaurants/restaurant/3

    // http://localhost:2019/restaurants/restaurants

    // http://localhost:2019/restaurants/restaurant/likename/eat
}
