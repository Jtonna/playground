package com.jtonna.rsocketserver.controller;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.annotation.ConnectMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ServerCallClientExample
{

    // Array List for keeping a record of clients
    private final List<RSocketRequester> CLIENTS = new ArrayList<>();

    // @ConnectMapping annotation lets us listen to client connection events AS they happen.
    // In this example we will add clients to a CLIENTS list & ask for telemetry streams.
    @ConnectMapping("shell-client")
    void connectShellClientAndAskForTelemetry(RSocketRequester rSocketRequester, @Payload String client)
    {

        /*
          rSocketRequester.rsocket() returns a reactive Mono Object, which contains all the callbacks we need.

          This code might feel counter-intuitive — calling onClose() while a client’s connecting and then using
          the resulting mono to store a reference to the new client. Sometimes, event-driven API’s can feel
          a bit odd. But think of it as the mono for this RSocket connection sending you an “I’m alive” event.
          You’re using that creation event to trigger the storage of each client’s reference in the list.
         */
        rSocketRequester.rsocket()
                .onClose() // (1)
                .doFirst(() -> {
                    System.out.println("Client: {} CONNECTED." + client);
                    CLIENTS.add(rSocketRequester);
                }) // (2) doFirst method adds the client to the client array list
                .doOnError(error -> {
                    System.out.println("Channel to client {} CLOSED" + client);
                })// (3) doOnError method triggers when theres a problem with the connection (ie client closing connection)
                .doFinally(consumer -> {
                    CLIENTS.remove(rSocketRequester);
                    System.out.println("Client {} DISCONNECTED" + client);
                }) // (4) doFinally gets triggered when the connection closes.
                .subscribe(); // (5) Activates the reactive code we added to the mono & signals that we are ready to process events

        // Callback to client, confirming connection.
        rSocketRequester.route("client-status")
                .data("OPEN")
                .retrieveFlux(String.class)
                .doOnNext(s -> System.out.println("Client: {" + client + "} Free Memory: {" + s + "}."))
                .subscribe();
    }

}
