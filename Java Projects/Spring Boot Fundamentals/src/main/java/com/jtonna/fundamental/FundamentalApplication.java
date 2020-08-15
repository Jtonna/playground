package com.jtonna.fundamental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentalApplication {
    public static void main(String[] args) {
        SpringApplication.run(FundamentalApplication.class, args);
        System.out.println("Hello Jacob");
    }

}
