package com.Redis.Client;

import redis.clients.jedis.Jedis;

/**
 * Created：Jeffrey
 * date   ：2021/8/17 17:46
 */
public class TestRedis003 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.0.102", 6379);
        System.out.println(jedis.get("REDIS_KEY1"));
        jedis.setnx("1","2");
        jedis.setex("1",10,"2");
        jedis.del("");



        jedis.hget("","");






    }
}
