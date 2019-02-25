package com.curtain.domaindrivendesign.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Curtain
 * @date 2019/1/2 10:56
 */
@Service
public class ValueService {


    private final Map<String, String> map = new HashMap<>();

    {
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
    }

    @Cacheable(value = "test", key = "#key")
    public String get(String key) {
        return map.get(key);
    }
}

