package com.limethecoder.repository.impl;

import com.limethecoder.domain.Tweet;
import com.limethecoder.domain.User;
import com.limethecoder.infastructure.PostConstructBean;
import com.limethecoder.repository.TweetRepository;

import java.util.ArrayList;
import java.util.List;


public class SimpleTweetRepository implements TweetRepository {
    private List<Tweet> tweets = new ArrayList<>();

    @Override
    public List<Tweet> findAll() {
        return tweets;
    }

    @Override
    public void save(Tweet tweet) {
        tweets.add(tweet);
    }

    @Override
    public void init() {
        tweets.add(new Tweet(new User("Joe"), "Hello, world!"));
        tweets.add(new Tweet(new User("Alex"), "Yo, yo!"));
    }

    @PostConstructBean
    public void initializer() {
        tweets.add(new Tweet(new User("Mia"), "I'm coolest in the world!"));
    }
}
