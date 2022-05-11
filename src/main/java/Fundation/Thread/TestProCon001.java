package Fundation.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created：Jeffrey
 * date   ：2021/9/3 15:25
 */
public class TestProCon001 {
    static Object obj = new Object();
    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition condition = reentrantLock.newCondition();  //JVM同一把锁
    static List list = new ArrayList<>();                       //JVM共享数据

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            //====生产者=====
            Thread producer = new Thread(new Producer());
            producer.start();

            //====消费者=====
            Thread consumer = new Thread(new Consumer());
            consumer.start();
        }


    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();
                Random random = new Random();

                //1.list已经有数据，等待消费者先消费掉数据
                if (list.size() > 0) {
                    try {
                        condition.await(); //先释放aqs锁，进入condition等待队列；被通知后，重新进入aqs队列

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //消费完，生产数据
                list.add(random.nextInt(100));
                condition.signalAll();
                reentrantLock.unlock();
            }


        }

    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();
                //1.有数据，直接消费
                if (list.size() > 0) {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "消费了:" + list.remove(0));

                        condition.signalAll();//消费完了，通知生产
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {

                    //2.没有数据，等待生产
//                    obj.notify();
                    try {
                        condition.await(); //进入condition等待队列
                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                reentrantLock.unlock();
            }
        }
    }
}
