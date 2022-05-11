package com.Lock;

import Fundation.User;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created：Jeffrey
 * date   ：2020/6/29 10:40
 */
public class LockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock=new ReentrantLock(true);
        reentrantLock.lock();
        reentrantLock.unlock();
        User user;
//        synchronized (LockTest.class) {
//            user = new User("1");
//        }
        new LockTest().task();
//        System.out.println(ClassLayout.parseInstance(user).toPrintable());
    }

   synchronized   void task(){

    }
}
