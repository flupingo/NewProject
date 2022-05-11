package com.Redis.Lock;


import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import scala.tools.nsc.settings.Final;

import java.util.UUID;

/**
 * Created：Jeffrey
 * date   ：2021/7/8 14:42
 */
@Component
public class RedisLock {
//    @Autowired
//    JedisPool jedisPool;   //需要配置

    private static final Jedis JEDIS = new Jedis("192.168.0.102", 6379);

    public static void main(String[] args) {
        query("key");
    }

    public static void query(String key) {

        //上锁: 接受返回随机数
        String result = lock("key", "");
        //操作DB
        if (result != null) {
            //1.操作DB
            //2.解锁
            unLock("key", result);
        } else {
            try {
                Thread.sleep(10);
                query("key");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //上锁
    static String lock(String key, String value) {
        String uuid = UUID.randomUUID().toString();
        String result = JEDIS.set(key, uuid, "nx", "ex", 100);
        if (result != null) {
            return uuid;
        } else {
            return null;
        }
    }

    //解锁
    static void unLock(String key, String uuid) {
        //先判断是自己的锁
        String result = JEDIS.get(key);
        if (result == uuid) {
            JEDIS.del(key);
        }


    }

}
