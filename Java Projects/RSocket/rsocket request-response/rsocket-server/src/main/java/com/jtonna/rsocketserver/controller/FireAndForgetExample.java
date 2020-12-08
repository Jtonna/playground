package com.jtonna.rsocketserver.controller;

import com.jtonna.rsocketserver.models.RSocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * This FireAndForgetExample demonstrates how fire and forget works;
 * it accepts data & simply doesnt return anything; but it could do anything it wants with said data.
 */
@Controller
public class FireAndForgetExample
{

    @MessageMapping("fire-and-forget")
    public void fireAndForget(RSocketMessage rSocketMessage)
    {
        System.out.println("fire-and-forget received your RSocketMessage: " + rSocketMessage);
    }

}
