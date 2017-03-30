package com.limethecoder.infastructure;


import com.limethecoder.repository.impl.SimpleTweetRepository;

import java.util.HashMap;
import java.util.Map;

public class JavaConfig implements Config {

    private final Map<String, Class<?>> context = new HashMap<>();

    {
        context.put("tweetRepo", SimpleTweetRepository.class);
    }

    @Override
    public Class<?> getImpl(String name) {
        return context.get(name);
    }
}
