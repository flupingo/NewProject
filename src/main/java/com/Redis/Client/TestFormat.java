package com.Redis.Client;

import java.text.MessageFormat;

/**
 * Created：Jeffrey
 * date   ：2021/8/29 21:27
 */
public class TestFormat {
    public static void main(String[] args) {
        String a = MessageFormat.format("RKB:ESCache  {0};{1}", "key", "field");
        System.out.println(a);

    }
}
