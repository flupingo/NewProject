package com.JVM;

/**
 * Created：Jeffrey
 * date   ：2021/8/2 16:23
 */
public class TestIntern {
    public static void main(String[] args) {
        String a = "1";
        String b = new String("asdf").intern();

        String c = new StringBuilder("a").toString();
    }
}
