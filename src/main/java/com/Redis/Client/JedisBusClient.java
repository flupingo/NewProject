package com.Redis.Client;

import com.Redis.Thread.MyThread;

/**
 * Created：Jeffrey
 * date   ：2020/7/18 17:37
 */
public class JedisBusClient {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();

    }
}
