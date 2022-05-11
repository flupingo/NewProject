package com.JVM;

/**
 * Created：Jeffrey
 * date   ：2021/7/26 18:18
 */
public class TestDynamic {
    int num;

    public static void main(String[] args) {


    }

    public void methodA() {
        System.out.println("methodA.....");

    }

    public void methodB() {
        System.out.println("methodB....");
        methodA();
        num++;

    }


}
