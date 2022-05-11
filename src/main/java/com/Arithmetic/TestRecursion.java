package com.Arithmetic;

/**
 * 递归
 * Created：Jeffrey
 * date   ：2021/8/8 16:54
 */
public class TestRecursion {
    public static void main(String[] args) {
        test001(4);


    }

    static void test001(int n) {
        if (n > 2) {
            test001(n - 1);
        }
        System.out.println("n=" + n);
    }

}
