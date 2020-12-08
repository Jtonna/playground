package com.jtonna.rsocketclient.util.rsocket_tools.shell;

import com.jtonna.rsocketclient.models.RSocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import reactor.core.Disposable;

import java.time.LocalDateTime;

@ShellComponent // Tells spring we are developing a shell based component
public class RSocketShellClient
{

    private static final String CLIENT = "Client";
    private static final String REQUEST = "Request";
    private static final String FIRE_AND_FORGET = "fire-and-forget";
    private static final String STREAM = "Stream";

    // Add a global class for Disposable.
    private Disposable disposable;

    // Add a global class variable for the RSocketRequester.
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

    @ShellMethod("Send one request. No response will be returned.")
    public void fireAndForget() throws InterruptedException
    {
        System.out.println("\nfire-and-forget. Received request, expect no response.\n");

        this.rsocketRequester
                .route("fire-and-forget")
                .data(new RSocketMessage(CLIENT, FIRE_AND_FORGET))
                .send()
                .block();
    }

    @ShellMethod("Send one request. ,amy responses (stream) will be received.")
    public void stream()
    {
        System.out.println("\nstream. Sending one request, Waiting for unknown amount of responses. (Stop process to quit, or write response-limiting logic on client or server)");

        this.disposable = this.rsocketRequester
                .route("stream")
                .data(new RSocketMessage(CLIENT, STREAM))
                .retrieveFlux(RSocketMessage.class)
                .subscribe( er -> System.out.println("Response Received from Stream: " + er));
    }

    @ShellMethod("Stop streaming messages from the server.")
    public void s()
    {
        if(null != disposable)
        {
            disposable.dispose();
        }
    }
}
