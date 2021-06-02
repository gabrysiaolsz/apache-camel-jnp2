package com.example.twitter;

import java.util.Date;

public class TweetInfo {

    private String text;
    private String username;
    private Integer favouriteCount;
    private Date creationDate;

    public TweetInfo() {
    }

    public TweetInfo(String text, String username, Integer favouriteCount, Date creationDate) {
        this.text = text;
        this.username = username;
        this.favouriteCount = favouriteCount;
        this.creationDate = creationDate;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFavouriteCount(Integer favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "[text = " + text + ", username = " + username +
                ", favouriteCount = " + favouriteCount + ", creationDate = " + creationDate + "]";
    }

}
