package com.Lock;

import Fundation.Animal;
import Fundation.Dog;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2021/8/28 16:45
 */
public class ThreadLocal001 {
    ThreadLocal<String> threadLocal = new ThreadLocal();

    private String content;    //值不存在对象里，而是存在threadLocal，实现线程隔离

    public String getContent() {
        return threadLocal.get();
    }

    public void setContent(String co) {
        threadLocal.set(co);
    }

    //static修饰，方便别的类访问
    public static ThreadLocal<Dog> dogThreadLocal = new ThreadLocal<>();
    public static ThreadLocal<Animal> dogThreadLoca2 = new ThreadLocal<>();


    public static void main(String[] args) {
        dogThreadLocal.set(new Dog());
        System.out.println(dogThreadLocal.get());


        dogThreadLoca2.set(() -> System.out.println(""));
        dogThreadLoca2.get();
        System.out.println(dogThreadLocal.get());
        System.out.println(dogThreadLoca2.get());
        test();


        ThreadLocal threadLocal = new ThreadLocal() {

        };

        //新Thread，塞自己的隔离数据
        Thread thread22 = new Thread(() -> {
            ThreadLocal<Dog> dogThreadLocal = new ThreadLocal<>();
            ThreadLocal<Object> dogThreadLoca2 = new ThreadLocal<>();
            ThreadLocal<Animal> dogThreadLoca3 = new ThreadLocal<>();
            dogThreadLocal.set(new Dog());
            dogThreadLoca2.set(new Object());
            System.out.println("===thread22===");
            System.out.println(Thread.currentThread().toString() + dogThreadLocal);

        });
        thread22.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadLocal.set(2);
        System.out.println(threadLocal.get());
//        Object o = threadLocal.get();

        threadLocal.set(3);
        System.out.println(threadLocal.get());
        System.out.println("====");

        StringUtils.isNotEmpty("123");

        List list = new ArrayList<>();
        CollectionUtils.isNotEmpty(list);

        ThreadLocal001 t = new ThreadLocal001();
        for (int i = 0; i < 200; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    t.setContent(Thread.currentThread().getName()); //设值
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "===>" + t.getContent()); //取值
                }
            });
            thread.start();
        }


        Thread thread = new Thread(() -> {
            System.out.println("==");
        });
        thread.start();
        thread.run();

    }

    static void test() {
        System.out.println("==test===");
        System.out.println(Thread.currentThread().toString() + dogThreadLocal.get());

    }


}
