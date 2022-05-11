package com.Lock;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created：Jeffrey
 * date   ：2021/9/4 9:44
 */
public class TestSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(10); //停车场1只有1个车位，默认非公平锁
        Semaphore semaphore2 = new Semaphore(1); //停车场2只有1个车位
        for (int j = 0; j < 20; j++) {
            Thread thread = new Thread(() -> {
                try {
                    semaphore1.acquire(1);

                    semaphore1.tryAcquire(1);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        ReentrantLock reentrantLock = new ReentrantLock(false);
        reentrantLock.tryLock();

        reentrantLock.lock();
        reentrantLock.unlock();


        if (reentrantLock.isHeldByCurrentThread()) {
            reentrantLock.unlock();
        }


        try {
            boolean flag = semaphore1.tryAcquire(1);
            semaphore1.release();


            semaphore1.acquire(1);//acquire会阻塞
            semaphore1.acquire(2);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //=====通过循环来实现反复抢锁的动作，而不是通过阻塞队列====-

        Thread thread1 = new Thread(() -> {
            String name = "Thread1";
            while (true) {
                try {
                    if (semaphore1.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(name + "抢到停车场1的车位！！！");
                        if (semaphore2.tryAcquire(1, TimeUnit.SECONDS)) {
                            System.out.println(name + "抢到停车场2的车位！！！");
                            Thread.sleep(1000);
                        } else {
                            System.out.println(name + "没抢到停车场2的车位！！！");
                        }
                    } else {
                        System.out.println(name + "没抢到停车场1的车位！！！");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                semaphore1.release();
                semaphore2.release();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        thread1.start();

        Thread thread2 = new Thread(() -> {
            String name = "Thread2";
            while (true) {
                try {
                    if (semaphore2.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(name + "抢到停车场2的车位！！！");
                        if (semaphore1.tryAcquire(1, TimeUnit.SECONDS)) {
                            System.out.println(name + "抢到停车场1的车位！！！");
                            Thread.sleep(1000);
                        } else {
                            System.out.println(name + "没抢到停车场1的车位！！！");
                        }
                    } else {
                        System.out.println(name + "没抢到停车场2的车位！！！");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                semaphore1.release();
                semaphore2.release();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        thread2.start();


        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        Thread thread3 = new Thread(() -> {
            String name = "Thread3";
//                lock1.lock();
            while (true) {
                try {
                    //上锁
                    if (lock1.tryLock()) {
                        System.out.println(name + "抢到lock1");
                        if (lock2.tryLock()) {
                            System.out.println(name + "抢到lock2");
                            Thread.sleep(1000);
                        } else {
                            System.out.println(name + "没抢到lock2");
                        }
                    } else {
                        System.out.println(name + "没抢到lock1");
                    }

                    //锁被该线程占有，才解锁，因为是trylock()，不是lock()
                    if (((ReentrantLock) lock1).isHeldByCurrentThread()) {
                        lock1.unlock();
                    }
                    if (((ReentrantLock) lock2).isHeldByCurrentThread()) {
                        lock2.unlock();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();
        Thread thread4 = new Thread(() -> {
            String name = "Thread4";
//                lock1.lock();
            while (true) {
                try {
                    if (lock2.tryLock()) {
                        System.out.println(name + "抢到lock2");
                        if (lock1.tryLock()) {
                            System.out.println(name + "抢到lock1");
                            Thread.sleep(1000);
                        } else {
                            System.out.println(name + "没抢到lock1");
                        }
                    } else {
                        System.out.println(name + "没抢到lock2");
                    }
                    if (((ReentrantLock) lock1).isHeldByCurrentThread()) {  //lock1锁被当前线程持有
                        lock1.unlock();
                    }
                    if (((ReentrantLock) lock2).isHeldByCurrentThread()) {
                        lock2.unlock();
                    }
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread4.start();


    }
}
