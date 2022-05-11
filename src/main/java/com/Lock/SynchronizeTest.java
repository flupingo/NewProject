package com.Lock;

/**
 * Created：Jeffrey
 * date   ：2021/5/16 16:05
 */
public class SynchronizeTest {
    public static void main(String[] args) {
        //【秒杀】：高并发，多线程访问同一个数据，用一个锁，实现原子操作？？？


        //访问数据存在mysql里

        final int num = 0;
        Object obj = new Object();
        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    int num1;
                    synchronized (obj) {
                        num1 = num - 1;
                    }
                    System.out.println(Thread.currentThread().getName()+":"+num1);
                }
            }
        });
        thread01.start();

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    int num1;
                    synchronized (obj) {
                        num1 = num - 1;
                    }
                    System.out.println(Thread.currentThread().getName()+":"+num1);
                }
            }
        });
        thread02.start();


    }
}
