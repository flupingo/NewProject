package com.Lock;

import org.apache.kafka.common.utils.SystemTime;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created：Jeffrey
 * date   ：2021/9/3 19:53
 */
public class TestCondition {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition001 = reentrantLock.newCondition();
        Condition condition002 = reentrantLock.newCondition();

        try {
//            condition001.await();
//            condition001.signalAll();

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 100L,
                    TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(100), new ThreadPoolExecutor.AbortPolicy());
            Future<Long> future = threadPoolExecutor.submit(new Callable<Long>() {
                @Override
                public Long call() {
                    System.out.println(Thread.currentThread().getName() + "call执行开始");
                    Long start = System.currentTimeMillis();
                    try {
                        Thread.sleep(2000);
                        Long end = System.currentTimeMillis();
                        System.out.println(Thread.currentThread().getName() + "call执行结束");
                        return end - start;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 1L;
                }
            });
            System.out.println("开始拉取数据");

            Long s = future.get();//需要等call()方法执行完，才能往下走

            Long s1 = future.get(10, TimeUnit.SECONDS);
            System.out.println(s);

            System.out.println("拉取结束");
            threadPoolExecutor.shutdown();
            System.out.println("关闭线程池");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
