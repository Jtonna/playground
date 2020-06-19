package com.jtonna.crudyrestaurants.services;

import com.jtonna.crudyrestaurants.models.Restaurant;
import com.jtonna.crudyrestaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

//| note: When creating these we need to Generate Override Methods from the RestaurantService & then modify the null returns

@Service(value = "restaurantService") // We need to tell spring this is a service and give it a service name
public class RestaurantServiceImpl implements RestaurantService
{

    // Connect this Class to the RestaurantRepository
    @Autowired
    RestaurantRepository restaurantRepository;

    // Returns a LIST of restaurants.
    @Override
    public List<Restaurant> findAllRestaurants()
    {
        // Create a list to add stuff to
        List<Restaurant> rtnList = new ArrayList<>();

        restaurantRepository.findAll() // Get ALL of the restaurants, this gets returned as an iterator
                .iterator() // We are now working with the iterator data
                .forEachRemaining(rtnList::add); // for each remaining in the iterator we put it in the array list

        // At this point we have an array list that we can sort, filter or whatever we want.

        return rtnList;
    }

    // Finds and returns ONE single restaurant
    @Override
    public Restaurant findRestaurantById(long id)
    {
        return restaurantRepository.findById(id) // findAllById built in to JPA, we just send the primary Key
                .orElseThrow(() -> new EntityNotFoundException("Restaurant " + id + " not found.")); // If we cant find it, we will tell the user who requested it
    }

    // JPA has thousands of built in methods, but many are not "exposed" so inside of the Restaurant Repo we will expose the one we want to use
    @Override
    public List<Restaurant> findByNameLike(String thename)
    {
        // The JPA Method we exposed is the one we are going to use
        return restaurantRepository.findByNameContainingIgnoringCase(thename);
    }
}
