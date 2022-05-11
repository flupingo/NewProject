package com.Redis.Client;

import redis.clients.jedis.Jedis;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2020/7/18 17:01
 */
public class Client {
    public static void main(String[] args) {
        //1.连接Redis:Redis服务器的IP + port
        System.out.println(MessageFormat.format("wo{0}", "2"));
        Jedis jedis = new Jedis("192.168.0.103", 6379);

        HashMap map = new HashMap<>();
        map.put(1, 2);


        //2.操作Redis
        //2.0 公共操作
        jedis.set("age", "123");
        System.out.println(jedis.del("age"));
        jedis.expire("name", 60 * 60);//给key绑定失效时间
        jedis.exists("name");
        jedis.incr("age"); //自增

        //2.1 String
        jedis.set("name", "yang");
        jedis.setex("name", 60, "zhang"); //expire--失效时间
        jedis.get("name");
        jedis.mset("name", "zhao", "age", "2");
        jedis.setnx("name", "sdf");  //key存在则不赋值
        jedis.set("name01", "222");

        //返回value减1后的值！！！
        jedis.decr("name01");

        //2.2 List
        jedis.lpush("list", "a", "b", "c");    //从前面加
        jedis.rpush("list1", "x");            //从后面加

        //获取list长度
        System.out.println(jedis.llen("list"));
        //指定list遍历序号！
        List<String> list = jedis.lrange("list", 0, jedis.llen("list"));
        System.out.println(list);


        //2.3 Map
        jedis.hset("hash1", "a1", "as");  //key,field,value即表、字段和值
        jedis.hget("hash1", "a1");

        //map-setnx，没有setex
        jedis.hsetnx("hash1", "a1", "a2");

        //删除key对应field,如果key对应的filed都被删了，最后一次删除，key也会被删！！！
        jedis.hdel("hash1", "a2");

//        System.out.println(jedis.hgetAll("hash1"));
//        System.out.println(jedis.hlen("hash1"));

        //3.关闭Redis服务
        jedis.close();

    }
}
