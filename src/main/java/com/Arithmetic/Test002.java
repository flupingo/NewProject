package com.Arithmetic;

/**
 * Created：Jeffrey
 * date   ：2021/7/14 10:47
 */
public class Test002 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 5, 8, 2, 3, 9, 4};
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                int tem = 0;
                if (numbers[j] > numbers[j + 1]) {
                    //顺序调整
                    tem = numbers[j]; //j解脱
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tem;
                }
            }
        }
        System.out.println(numbers);

    }
}
