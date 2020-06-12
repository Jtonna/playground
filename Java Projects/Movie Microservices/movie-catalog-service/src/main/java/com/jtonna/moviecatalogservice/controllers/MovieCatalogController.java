package com.jtonna.moviecatalogservice.controllers;

import com.jtonna.moviecatalogservice.models.CatalogItem;
import com.jtonna.moviecatalogservice.models.Movie;
import com.jtonna.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController
{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{movieId}")
    public List<CatalogItem> getCatalog(@PathVariable("movieId") String movieId)
    {

        // get all rated movie id's
        List<Rating> ratings = Arrays.asList(
                new Rating ("1234", 4),
                new Rating("5679", 2)
        );

        /// for each movie id, call movie info service and get details

        return ratings.stream().map(rating -> {
        Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);

//        Below is an example of how we should be doing things in the future because restTemplate is due to become deprecated
//        Movie movie = WebClient.builder().build()
//                .get()
//                .uri("http://localhost:8082/movies/" + rating.getMovieId())
//                .retrieve()
//                .bodyToMono(Movie.class)
//                .block();

            return new CatalogItem(movie.getName(),"this movie is about....", rating.getRating());
        }).collect(Collectors.toList());

        // put them together to return the info

    }
}
