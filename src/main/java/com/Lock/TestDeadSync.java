package com.Lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created：Jeffrey
 * date   ：2021/9/4 8:42
 */
public class TestDeadSync {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Semaphore semaphore1 = new Semaphore(1); //默认非公平锁
        Semaphore semaphore2 = new Semaphore(2);
        semaphore1.tryAcquire();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1) {
                    System.out.println("抢到obj1");
                    synchronized (obj2) {

                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj2) {
                    System.out.println("抢到obj2");
                    synchronized (obj1) {

                    }
                }
            }
        });

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        ((ReentrantLock) lock1).isHeldByCurrentThread();//???

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock1.lock();
                System.out.println("抢到lock1");
                lock2.lock();
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock2.lock();
                ((ReentrantLock) lock1).isLocked();
                System.out.println("抢到lock2");
                lock1.lock();
                lock1.unlock();
            }
        });

    }
}
