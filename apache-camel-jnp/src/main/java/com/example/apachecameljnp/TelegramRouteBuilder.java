package com.example.apachecameljnp;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TelegramRouteBuilder extends RouteBuilder {

    private String authorizationToken;

    private String chatId;

    public TelegramRouteBuilder(String authorizationToken, String chatId) {
        super();
        this.authorizationToken = new String(authorizationToken);
        this.chatId = new String(chatId);
    }

    @Override
    public void configure() throws Exception {
        from("direct:start")
                .toF("telegram:bots?authorizationToken=%s&chatId=%s", authorizationToken, chatId);
    }
}
