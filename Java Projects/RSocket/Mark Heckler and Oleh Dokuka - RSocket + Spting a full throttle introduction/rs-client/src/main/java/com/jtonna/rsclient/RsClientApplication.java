package com.jtonna.rsclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;

@SpringBootApplication
public class RsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsClientApplication.class, args);
    }

}


@Configuration
class ClientConfig {
    @Bean
    RSocketRequester requester(RSocketRequester.Builder builder)
    {
        return builder.tcp("localhost", 9091);
    }
}

@Component
@AllArgsConstructor
class AircraftClient {

    private RSocketRequester requester;

    @PostConstruct
    void reqResp() {
        requester.route("reqresp")
                .data(Instant.now())
                .retrieveMono(Aircraft.class)
                .subscribe( ac -> System.out.println("response: " + ac))
        ;
    }
}

@Data
@AllArgsConstructor
class Aircraft {
    private String callsign, reg, flightno, type;
    private int altitude, heading, speed;
    private double lat, lon;
}