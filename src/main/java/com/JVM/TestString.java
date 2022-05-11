package com.JVM;

/**
 * Created：Jeffrey
 * date   ：2021/8/1 21:15
 */
public class TestString {
    public static void main(String[] args) {
        String a = "abc";
        a += "ac";
        String b = a + "1";
        StringBuilder s=new StringBuilder(); //默认容量16的 char[]
        s.append("1");
        s.toString();
        String.valueOf(1);

        System.out.println("123");

        Integer sss=12;
        sss.toString();
    }
}
