package com.jtonna.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

@Configuration
class ServerConfig
{

    @Bean
    WebClient client(){
        return WebClient.create("http://localhost:7634/aircraft");
    }

}

@Controller
@AllArgsConstructor
class AircraftServerController {
    private WebClient client;

    // request response
    @MessageMapping("reqresp")
    Mono<Aircraft> reqResp(Mono<String> timestampMONO)
    {
        return timestampMONO.doOnNext(ts -> System.out.println(ts))
                .then(client.get()
                        .retrieve()
                        .bodyToFlux(Aircraft.class)
                        .next()
                );
    }

    // request stream

    // fire and forget

    // bidirectional channel

}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Aircraft {
    private String callsign, reg, flightno, type;
    private int altitude, heading, speed;
    private double lat, lon;
}