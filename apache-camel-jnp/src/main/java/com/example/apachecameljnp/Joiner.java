package com.example.apachecameljnp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Joiner {

    @Value("${telegram.authorizationToken}")
    private String authorizationToken;

    @Value("${telegram.chatId}")
    private String chatId;

    public Joiner() {
    }

    @PostConstruct
    public void start() throws Exception {
         Context contextClass = new Context();
         TelegramRouteBuilder telegramRouteBuilder = new TelegramRouteBuilder(authorizationToken, chatId);
         TelegramStartupListener telegramStartupListener = new TelegramStartupListener();

         contextClass.addRoutes(telegramRouteBuilder);
         contextClass.addStartupListener(telegramStartupListener);
    }

}
