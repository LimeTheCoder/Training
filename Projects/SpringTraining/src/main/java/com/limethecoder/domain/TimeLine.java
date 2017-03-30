package com.limethecoder.domain;


import java.util.ArrayList;
import java.util.List;

public class TimeLine {
    private final List<Tweet> tweets = new ArrayList<Tweet>();

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public void removeTweet(Tweet tweet) {
        tweets.remove(tweet);
    }
}
