package Fundation.Thread;

import Fundation.Dog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created：Jeffrey
 * date   ：2021/6/21 15:16
 */
public class TestThreadLocal {
    public static Map<String, Object> MAP = new ConcurrentHashMap<>();
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    static Object obj = new Object();

    volatile static Cat cat = new Cat("小猫");
    static ReentrantLock reentrantLock = new ReentrantLock();


    static int b = 0;  //共享变量


    public static void main(String[] args) throws Exception {
        threadLocal.set("12");
        lock();
//        new TestThreadLocal().test();
//        Thread thread = new Thread(() -> {
//            synchronized (cat) {
//                try {
//                    System.out.println("!!!");
//                    Thread.sleep(15000);
//                    System.out.println("!!!");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            threadLocal.set("3");
////            System.out.println(threadLocal.get());//3
//        });
//        thread.start();
//
//        new Thread(()->{
//            System.out.println("-----");
////            System.out.println(cat.getName());
//            synchronized (cat) {
//                System.out.println("--cat");
//            }
//        }).start();
//
////        Thread.sleep(1000);
//        System.out.println("++++++");
//        synchronized (cat) {
//            System.out.println("+++cat");
//        }
//        System.out.println(threadLocal.get());//12

        try {
            Thread.sleep(2000);
            System.out.println("main完");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        Dog dog = new Dog();
        ClassLoader classLoader = dog.getClass().getClassLoader();

//        threadLocal.set("1");


    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class Cat {
        private String name;
    }


    public static void test() {
        Thread thread = new Thread(() -> {
            synchronized (cat) {
                try {
                    System.out.println("!!!");
                    b = b + 10;
                    Thread.sleep(15000);
                    System.out.println("!!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            threadLocal.set("3");
//            System.out.println(threadLocal.get());//3
        });
        thread.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println("-----");
            b = b + 10;
            System.out.println(cat.getName());
//            synchronized (cat) {
//                System.out.println("--cat");
//            }
        }).start();

        System.out.println("++++++");
        synchronized (cat) {
            System.out.println("+++cat");
        }
    }

    public static void lock() {
        Thread thread = new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("!!!");
                Thread.sleep(15000);
                System.out.println("!!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
            threadLocal.set("3");
//            System.out.println(threadLocal.get());//3
        });
        thread.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println("-----");
            reentrantLock.lock();
            System.out.println("---cat");


            reentrantLock.unlock();
        }).start();

        System.out.println("++++++");
        reentrantLock.lock();
        System.out.println("+++cat");
        reentrantLock.unlock();

    }
}
