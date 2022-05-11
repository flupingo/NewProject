package com.Redis.Client;

import redis.clients.jedis.Jedis;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created：Jeffrey
 * date   ：2021/7/7 19:03
 */
public class TestRedisLock {
    static Jedis jedis = new Jedis("192.168.0.101", 6379);

    public static void main(String[] args) throws Exception {


        String result = jedis.set("1", "1", "nx", "ex", 10);
//        jedis.setex("",1,"");
        System.out.println(result);
        System.out.println(System.currentTimeMillis());


        jedis.set("2", "1");
        jedis.setnx("1", "2");
        jedis.setex("1", 2, "2");
        jedis.del("1");

        jedis.hset("1", "1", "1");
        jedis.hdel("1", "1", "1");
        jedis.hget("1", "2");

        jedis.lset("1", 1, "");
        jedis.lpush("1", "1", "1");


        jedis.set("1", "2", "nx", "px", 1000);


        lock("唯一的key");
        //业务代码

        unLock("唯一的key");


        ReentrantLock reentrantLock = new ReentrantLock(false);
        reentrantLock.lock();
        //业务代码

        reentrantLock.unlock();


    }

    static void unLock(String key) throws Exception {
        String value = jedis.get(key);
        if (value != null) {
            //业务


        } else {
            Thread.sleep(10);
            unLock("");

        }
    }

    static void lock(String key) {
        String result = jedis.set(key, "1", "nx", "px", 100);
        //redis中途挂了


    }


}

