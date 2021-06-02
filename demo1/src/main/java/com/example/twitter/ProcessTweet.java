package com.example.twitter;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import twitter4j.Status;

public class ProcessTweet implements Processor {

    public void process(Exchange exchange) {
        Status bodyIn = (Status) exchange.getIn().getBody();

        TweetInfo tweetEntity = new TweetInfo();

        tweetEntity.setText(bodyIn.getText());

        if (bodyIn.getUser() != null) {
            tweetEntity.setUsername(bodyIn.getUser().getName());
        }

        tweetEntity.setFavouriteCount(bodyIn.getFavoriteCount());
        tweetEntity.setCreationDate(bodyIn.getCreatedAt());

        exchange.getIn().setBody(tweetEntity);
    }
}
