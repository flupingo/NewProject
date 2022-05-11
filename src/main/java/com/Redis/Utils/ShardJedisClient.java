package com.Redis.Utils;

import redis.clients.jedis.ShardedJedis;

/**
 * Created：Jeffrey
 * date   ：2020/10/22 16:40
 */
public class ShardJedisClient {
    public static void main(String[] args) {
        ShardJedisUtil shardJedisUtil = new ShardJedisUtil<String>() {
            @Override
            public String doAction(ShardedJedis shardedJedis) {
                return "String类型";
            }
        };

        ShardJedisUtil shardJedisUtil1 = new ShardJedisUtil<Long>() {
            @Override
            public Long doAction(ShardedJedis shardedJedis) {
                return 1L;
            }
        };
    }



}
