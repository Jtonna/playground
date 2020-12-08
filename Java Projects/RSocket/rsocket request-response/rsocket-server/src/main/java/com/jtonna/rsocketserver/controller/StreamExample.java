package com.jtonna.rsocketserver.controller;

import com.jtonna.rsocketserver.models.RSocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Controller
public class StreamExample
{

    @MessageMapping("stream")
    Flux<RSocketMessage> stream(RSocketMessage rSocketMessage)
    {
        System.out.println("\nRecieved stream request. " + rSocketMessage);

        return Flux
                .interval(Duration.ofSeconds(1))
                .map(index -> new RSocketMessage("SERVER", "STREAM", index))
                .log();
    }
}
