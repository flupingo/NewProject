package com.JVM;

/**
 * Created：Jeffrey
 * date   ：2021/7/27 10:54
 */
public class TestHeap001 {
    public static void main(String[] args) {
        System.out.println("start");
        try {
            Runtime runtime = Runtime.getRuntime();
            System.out.println(runtime.totalMemory() / 1024 / 1024);    //184m
            System.out.println(runtime.maxMemory() / 1024 / 1024);     //2700m
            Thread.sleep(100000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
