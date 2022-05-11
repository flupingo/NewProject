package com.Lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created：Jeffrey
 * date   ：2020/6/30 15:37
 */
public class CASTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger();
//        System.out.println(atomicInteger.);
        atomicInteger.incrementAndGet();
    }
}
