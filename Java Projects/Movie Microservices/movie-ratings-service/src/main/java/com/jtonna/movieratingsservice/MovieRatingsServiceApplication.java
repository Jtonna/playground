package com.jtonna.movieratingsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieRatingsServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MovieRatingsServiceApplication.class, args);
    }

}
