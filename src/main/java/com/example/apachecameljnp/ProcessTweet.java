package com.example.apachecameljnp;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import twitter4j.Status;

public class ProcessTweet implements Processor {

    TelegramJoiner telegramJoiner;

    public ProcessTweet(TelegramJoiner telegramJoiner) {
        super();
        this.telegramJoiner = telegramJoiner;
    }

    public void process(Exchange exchange) {
        Status bodyIn = (Status) exchange.getIn().getBody();

        TweetInfo tweetEntity = new TweetInfo();

        tweetEntity.setText(bodyIn.getText());

        if (bodyIn.getUser() != null) {
            tweetEntity.setUsername(bodyIn.getUser().getName());
        }

        tweetEntity.setFavouriteCount(bodyIn.getFavoriteCount());
        tweetEntity.setCreationDate(bodyIn.getCreatedAt());

        //exchange.getIn().setBody(tweetEntity);
        telegramJoiner.setMessage(tweetEntity.toString());
    }
}