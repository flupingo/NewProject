package Fundation.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created：Jeffrey
 * date   ：2021/9/3 15:25
 */
public class TestProCon002 {
    static Object obj = new Object();
    static List list = new ArrayList<>();

    public static void main(String[] args) {
        //====生产者=====
        for (int i = 0; i < 5; i++) {
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
                synchronized (obj) {
                    //没数据，先生产
                    if (list.isEmpty()) {
                        Random random = new Random();
                        list.add(random.nextInt(100));
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "生产了:" + list.get(0));
                    }
                    //有数据了
                    obj.notify(); //通知消费者消费

                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (obj) {

                    //没数据
                    if (list.isEmpty()) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //有数据，消费
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    obj.notify();

                }
            }
        }
    }
}
