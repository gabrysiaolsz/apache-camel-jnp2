package com.example.apachecameljnp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TelegramJoiner {

    @Value("${telegram.authorizationToken}")
    private String authorizationToken;

    @Value("${telegram.chatId}")
    private String chatId;

    public TelegramJoiner() {
    }

    TelegramStartupListener telegramStartupListener;

    public void setMessage(String message) {
        telegramStartupListener.setMessage(message);
    }

    @PostConstruct
    public void start() throws Exception {
         Context contextClass = new Context();
         TelegramRouteBuilder telegramRouteBuilder = new TelegramRouteBuilder(authorizationToken, chatId);
         telegramStartupListener = new TelegramStartupListener();

         contextClass.addRoutes(telegramRouteBuilder);
         contextClass.addStartupListener(telegramStartupListener);
    }

}
