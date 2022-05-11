package com.Lock;

/**
 * Created：Jeffrey
 * date   ：2020/6/29 18:30
 */
public class WaitNotifyTest {
    public static void main(String[] args) {
        final Object obj = new Object();

        //************不同的线程通过锁一个对象，实现共同管理************

        //1.第一个消费者
        Thread consumer01 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (obj) {
                        System.out.println("消费者1提出包子需求！！！");
                        try {
                            obj.wait();//若是wait(1000)则和sleep一样
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //需求满足后唤醒
                        System.out.println("消费者1开始吃包子！！！");
                    }
                }
            }
        });
        consumer01.start();//启动消费者线程
        //2.第二个消费者
        Thread consumer02 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (obj) {
                        System.out.println("消费者2提出包子需求！！！");
                        try {
                            obj.wait();//若是wait(1000)则和sleep一样
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //需求满足后唤醒
                        System.out.println("消费者2开始吃包子！！！");
                    }
                }
            }
        });
        consumer02.start();//启动消费者线程


        //3.生产者
        Thread creator = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);//生产包子中
                        System.out.println("生产包子中！！！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj) {
                        System.out.println("包子生产完成！！！");
                        obj.notify();//随机唤醒一个消费者
                    }
                }
            }
        });
        creator.start();//启动生产者线程


    }
}
