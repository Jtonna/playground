package com.jtonna.moviecatalogservice.controllers;

import com.jtonna.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController
{

    @RequestMapping("/{movieId}")
    public List<CatalogItem> getCatalog(@PathVariable("movieId") String movieId)
    {
        // get all rated movie id's

        /// for each movie id, call movie info service and get details

        // put them together to return the info


        return Collections.singletonList(
                new CatalogItem(
                        "Pixels",
                        "When aliens misinterpret video feeds of classic arcade games as a declaration of war against them, they attack the Earth using games like PAC-MAN, Donkey Kong, Galaga, Centipede and Space Invaders as…",
                        52
                )
        );
    }
}
