package com.Redis.Utils;

import redis.clients.jedis.ShardedJedis;

/**
 * Created：Jeffrey
 * date   ：2020/10/22 23:27
 */
public abstract class JedisAbstract<T> implements ShardJedisUtil {
    public abstract String doAction(ShardedJedis shardedJedis);

    protected String getName(String name) {
        return "name";
    }


}
