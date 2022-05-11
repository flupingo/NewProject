package com.Arithmetic;

/**
 * Created：Jeffrey
 * date   ：2021/7/25 16:42
 */
public class TestArray {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        arr[0][9] = 1;
        System.out.println(arr);


        Queue queueNode = new Queue(new Queue.Node("头节点"));


    }


    static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }
}
