package com.JVM;

/**
 * Created：Jeffrey
 * date   ：2021/7/26 16:22
 */
public class TestStack002 {
    public static void main(String[] args) {
        byte i = 15;//byte.short.char.bool.都以int存储
        int j = 8;
        int k = i + j;


    }

    public int getSum() {
        int m = 10;
        return m + 2;
    }

    public void testGetSum() {
        //获取上一个栈帧的结果，存到操作数栈中
        int a = getSum();
        int b = 20;
    }

    //从字节码角度理解 i++/++i
    public void add() {
        int i = 10;
        int j = 10;
        i++;
        ++j;

    }


}
