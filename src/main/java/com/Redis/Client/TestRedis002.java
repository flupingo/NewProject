package com.Redis.Client;

import redis.clients.jedis.Jedis;

/**
 * Created：Jeffrey
 * date   ：2021/7/3 15:49
 */
public class TestRedis002 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192");
        jedis.set("1","2");
        jedis.setnx("","");


        jedis.hset("","","");
        jedis.hget("","");
        jedis.hsetnx("","","");
        jedis.hdel("","");


        jedis.del("");
        jedis.expire("",1);


//        jedis.setex();




        jedis.setex("key",1,"3"); //设置超时时间+锁，原子操作
        jedis.setnx("1","2");
        jedis.del("key");//删除锁

        jedis.hset("","","");


    }
}
