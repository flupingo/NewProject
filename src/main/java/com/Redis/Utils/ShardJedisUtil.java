package com.Redis.Utils;

import redis.clients.jedis.ShardedJedis;

public interface ShardJedisUtil<T> {
    T doAction(ShardedJedis shardedJedis);//方法返回和类的泛型一致

//    T doPost(ShardedJedis shardedJedis);
}
