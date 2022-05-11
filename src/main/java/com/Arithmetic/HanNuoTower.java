package com.Arithmetic;

/**
 * 汉诺塔问题
 * Created：Jeffrey
 * date   ：2021/8/10 16:31
 */
public class HanNuoTower {
    public static void main(String[] args) {
        count(3, 'A', 'B', 'C');

    }

    static void count(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘子从" + a + "-->" + c);
        } else {
            count(num - 1, a, c, b);                               //1. n-1个盘子先a->b

            System.out.println("第" + num + "个盘子从" + a + "-->" + c); //2.n个盘子从a->c

            count(num - 1, b, a, c);                               //3. n-1再从b->c
        }
    }
}
