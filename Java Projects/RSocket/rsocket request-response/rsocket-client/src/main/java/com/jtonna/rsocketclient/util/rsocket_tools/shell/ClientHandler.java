package com.jtonna.rsocketclient.util.rsocket_tools.shell;

import org.springframework.messaging.handler.annotation.MessageMapping;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class ClientHandler
{

    @MessageMapping("client-status")
    public Flux<String> statusUpdate(String status)
    {
        System.out.println("Connection " + status);

        return Flux.interval(Duration.ofSeconds(5)).map(
                index -> String.valueOf(Runtime.getRuntime().freeMemory())
        );
    }


}