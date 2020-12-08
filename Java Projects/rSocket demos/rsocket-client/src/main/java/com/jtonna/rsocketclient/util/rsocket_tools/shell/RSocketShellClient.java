package com.jtonna.rsocketclient.util.rsocket_tools.shell;

import com.jtonna.rsocketclient.models.RSocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.time.LocalDateTime;

@ShellComponent // Tells spring we are developing a shell based component
public class RSocketShellClient
{

    private static final String CLIENT = "Client";
    private static final String REQUEST = "Request";
    // Add a global class variable for the RSocketRequester
    private final RSocketRequester rsocketRequester;

    // Use an Autowired constructor to customize the RSocketRequester and store a reference to it in the global variable
    @Autowired
    public RSocketShellClient(RSocketRequester.Builder rsocketRequesterBuilder) {
        this.rsocketRequester = rsocketRequesterBuilder
                .connectTcp("localhost", 7000)
                .block();
    }

    @ShellMethod("Send one request. One response will be printed")
    public void requestResponse() throws InterruptedException
    {
        System.out.println("\nSending one request. Waiting for one response. " + LocalDateTime.now().toString());

        RSocketMessage rSocketMessage = this.rsocketRequester
                .route("request-response")
                .data(new RSocketMessage(CLIENT, REQUEST))
                .retrieveMono(RSocketMessage.class)
                .block();

        System.out.println("Response was: " + rSocketMessage + " " + LocalDateTime.now().toString() + "\n");
    }
}
