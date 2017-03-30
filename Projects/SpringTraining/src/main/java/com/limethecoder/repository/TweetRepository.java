package com.limethecoder.repository;


import com.limethecoder.domain.Tweet;

import java.util.List;

public interface TweetRepository {
    List<Tweet> findAll();
    void save(Tweet tweet);
    void init();
}
