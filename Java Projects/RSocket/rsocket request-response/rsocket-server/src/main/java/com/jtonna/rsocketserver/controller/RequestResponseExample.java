package com.jtonna.rsocketserver.controller;

import com.jtonna.rsocketserver.models.RSocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * This RequestResponseExample demonstrates how an rSocket Controller's endpoint "request-response" works.
 *
 * The controller CAN OPTIONALLY take data in & and always give the user back data.
 */
@Controller
public class RequestResponseExample
{

    @MessageMapping("request-response")
    RSocketMessage requestResponseExample(RSocketMessage rSocketMessage)
    {
        System.out.println("\nrequest-response received your RSocketMessage: " + rSocketMessage);

        return new RSocketMessage("THE FUCKING CONTROLLER", "WHATEVER I WANT");
    }

}
