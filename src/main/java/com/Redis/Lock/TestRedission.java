package com.Redis.Lock;

import org.redisson.Redisson;
import org.redisson.api.RLock;

/**
 * Created：Jeffrey
 * date   ：2021/7/21 16:10
 */
public class TestRedission {
    public static void main(String[] args) {
        Redisson redisson = null;
        RLock rLock = redisson.getLock("keyName"); //根据key获取锁

        //1.上锁
        rLock.lock();
        //2.业务

        //3.解锁
        rLock.unlock();

    }
}
