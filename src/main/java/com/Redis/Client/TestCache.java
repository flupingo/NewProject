package com.Redis.Client;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created：Jeffrey
 * date   ：2021/7/8 10:40
 */
@Component
public class TestCache {

    @Cacheable(key = "getCache", value = "getCache")
    public String getCache(String name) {
        try {
            Thread.sleep(10);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return name;
        }
    }


}
