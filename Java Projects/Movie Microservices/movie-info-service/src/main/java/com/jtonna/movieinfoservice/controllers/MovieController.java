package com.jtonna.movieinfoservice.controllers;

import com.jtonna.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/movies")
public class MovieController
{

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@RequestParam("movieId") String movieId)
    {
        return new Movie(
                movieId,
                "Test Name"
        );
    }
}
