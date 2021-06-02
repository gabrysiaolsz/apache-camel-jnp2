package com.example.twitter;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.twitter.search.TwitterSearchComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwitterFeedRoute extends RouteBuilder {

    @Value("${twitter.consumerKey}")
    private String consumerKey;

    @Value("${twitter.consumerSecret}")
    private String consumerSecret;

    @Value("${twitter.accessToken}")
    private String accessToken;

    @Value("${twitter.accessTokenSecret}")
    private String accessTokenSecret;

    @Value("${app.interval}")
    protected int interval;

    @Value("${app.search_term}")
    protected String searchTerm;


    protected void prepareContextTwitterSearchComponent() {
        TwitterSearchComponent twitterSearchComponent = getContext().getComponent("twitter-search", TwitterSearchComponent.class);

        twitterSearchComponent.setAccessToken(accessToken);
        twitterSearchComponent.setAccessTokenSecret(accessTokenSecret);
        twitterSearchComponent.setConsumerKey(consumerKey);
        twitterSearchComponent.setConsumerSecret(consumerSecret);
    }

    @Override
    public void configure() {
        prepareContextTwitterSearchComponent();

        fromF("twitter-search://%s?delay=%s", searchTerm, interval)
                .process(new ProcessTweet()) //Translates the tweet.
                .log(LoggingLevel.INFO, "New tweet: ${body}");
    }
}

