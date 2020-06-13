package com.jtonna.movieratingsservice.controllers;

import com.jtonna.movieratingsservice.models.Rating;
import com.jtonna.movieratingsservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsController
{

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId)
    {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId)
    {
        // get all rated movie id's
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5679", 2)
        );

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;
    }
}
