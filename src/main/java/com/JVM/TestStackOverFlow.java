package com.JVM;

/**
 * Created：Jeffrey
 * date   ：2021/7/22 14:59
 */
public class TestStackOverFlow {
    private static int i = 1;

    public static void main(String[] args) {
        int a = 1;
        i++;
        System.out.println(i);
        main(args);

    }
}
