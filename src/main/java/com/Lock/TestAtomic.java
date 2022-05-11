package com.Lock;

import Fundation.Dog;

import java.io.StringWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created：Jeffrey
 * date   ：2021/9/3 7:53
 */
public class TestAtomic {
    public static AtomicInteger a = new AtomicInteger();
    public static ExecutorService service = Executors.newFixedThreadPool(10);

    static volatile int b = 0;

    public static void main(String[] args) {
//        a.set(1);
//        service.submit(() -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println(Thread.currentThread().toString() + b++);
//            }
//        });
//
//        service.submit((() -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println(Thread.currentThread().toString() + b++);
//            }
//        }));


        AtomicInteger c = new AtomicInteger();

        service.submit(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().toString() + c.incrementAndGet());
            }
        });

        service.submit((() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().toString() + c.incrementAndGet());
            }
        }));


        AtomicInteger atomicInteger = new AtomicInteger();

        //不同的线程可以操作同一个数，
        atomicInteger.set(1);
//        System.out.println(atomicInteger.incrementAndGet()); //原子 +1
        atomicInteger.decrementAndGet();


//        System.out.println(atomicInteger.decrementAndGet());//原子 -1
//        System.out.println(atomicInteger.incrementAndGet());


        AtomicReference<Dog> atomicReference = new AtomicReference();
        atomicReference.set(new Dog());
        atomicReference.compareAndSet(null, null);


//        System.out.println(atomicReference.get());


        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    condition.await();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        thread.start();


        int i = 10;
        for (; ; ) {
            i = --i;
//            System.out.println(i);
            if (i < 0) {
                break;
            }
        }
//        System.out.println(i);

    }
}
