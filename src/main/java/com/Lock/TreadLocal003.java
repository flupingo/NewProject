package com.Lock;

import Fundation.Dog;

/**
 * Created：Jeffrey
 * date   ：2022/3/24 22:04
 */
public class TreadLocal003 {
    public static void main(String[] args) {
        Thread thread22= new Thread(()->{
            System.out.println("===");
            ThreadLocal<Dog> dogThreadLocal=new ThreadLocal<>();
            dogThreadLocal.set(new Dog());
            System.out.println(dogThreadLocal);

        });
        thread22.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
