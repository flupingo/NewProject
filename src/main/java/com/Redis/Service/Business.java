package com.Redis.Service;

import redis.clients.jedis.Jedis;

/**
 * Created：Jeffrey
 * date   ：2020/7/18 17:31
 */
public class Business {
    //业务单元
    public void print() {
        System.out.println("业务执行！！！");
    }

    //控制单元
    public void control(String id) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String value = jedis.get("id") + id;
        if (null == value) {
            jedis.setex("id" + id, 20, Long.MAX_VALUE - 10 + "");
        } else {
            jedis.incr("id" + id);
            print();
        }
        jedis.close();
    }

}
