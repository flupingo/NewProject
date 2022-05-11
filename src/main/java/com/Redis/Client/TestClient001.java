package com.Redis.Client;

import redis.clients.jedis.Jedis;

/**
 * Created：Jeffrey
 * date   ：2021/6/6 10:47
 */
public class TestClient001 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.0.103", 6379);
        jedis.set("1", "2");
        System.out.println("setnx，返回:" + jedis.setnx("1", "222"));
        System.out.println(jedis.get("1"));
        jedis.setex("2", 100, "3");
//        while (jedis.get("2").equals("3")) {
//            break;
//        }
        jedis.del("1");
        System.out.println(jedis.get("1"));
        System.out.println("是否存在key-1  (0/1):" + jedis.exists("1"));

        //set和hset可以对同一个key操作吗？？
//        jedis.set("1", "2222");
        jedis.hset("1", "2", "3");

        //不同集合存key应该有不同的方式，不然会冲突！！！
        System.out.println(jedis.hget("1", "2"));
        System.out.println("是否存在key-1,field-2 :" + jedis.hexists("1", "2"));
        jedis.hdel("1", "2");
        System.out.println();
        jedis.hsetnx("1", "2", "3");

        jedis.lset("list", 1, "22");
        jedis.lpush("list", "2");
        jedis.lpush("list", "3");
        jedis.rpush("list", "-1");
        jedis.llen("list");
        System.out.println(jedis.lrange("list", 0, jedis.llen("list")));




    }
}
