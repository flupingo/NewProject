package com.Lock;

/**
 * Created：Jeffrey
 * date   ：2021/6/26 15:56
 */
public class TestWaitNotify002 {
    public static void main(String[] args) {
        final  Object obj=new Object(); //共享资源

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    obj.notify();
                }
            }
        });



    }
}
