package com.jtonna.rsocketserver.controller;

import com.jtonna.rsocketserver.models.RSocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class RequestResponseExample
{

    @MessageMapping("request-response")
    RSocketMessage requestResponseExample(RSocketMessage rSocketMessage)
    {
        System.out.println("request-response revieved your RSocketMessage: " + rSocketMessage);

        return new RSocketMessage("THE FUCKING CONTROLLER", "WHATEVER I WANT");
    }

}
