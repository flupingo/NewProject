package com.Redis.Utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedis;

/**
 * Created：Jeffrey
 * date   ：2020/8/7 22:56
 */
public class JedisUtils {
    public static Jedis getJedis() {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(30);//最大连接数
        jedisPoolConfig.setMaxIdle(10);//最大活动连接数
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
        return jedisPool.getResource();


    }

    public static void main(String[] args) {
        JedisUtils.getJedis();
        System.out.println("连接完成");

//        new ShardedJedisAction();
//        ShardedJedis shardedJedis=new ShardedJedis();
    }


}
