package com.jtonna.moviecatalogservice.controllers;

import com.jtonna.moviecatalogservice.models.CatalogItem;
import com.jtonna.moviecatalogservice.models.Movie;
import com.jtonna.moviecatalogservice.models.Rating;
import com.jtonna.moviecatalogservice.models.UserRating;
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

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
    {
        // Notice how the URL isnt an actual URL, we are using the service name that is registered on the eureka discovery server
        // We are able to do this because this is an eureka client & because of the @LoadBalanced annotation for the restTemplate bean
        UserRating ratings = restTemplate.getForObject("http://movie-ratings-service/ratingsdata/users/" + userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {

        /// for each movie id, call movie info service and get details
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

        // put them together to return the info
            return new CatalogItem(movie.getName(),"this movie is about....", rating.getRating());
        }).collect(Collectors.toList());
        
    }
}


//        Below is an example of how we should be doing things in the future because restTemplate is due to become deprecated
//        Movie movie = WebClient.builder().build()
//                .get()
//                .uri("http://localhost:8082/movies/" + rating.getMovieId())
//                .retrieve()
//                .bodyToMono(Movie.class)
//                .block();
