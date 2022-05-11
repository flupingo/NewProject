package com.JVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created：Jeffrey
 * date   ：2021/7/27 14:52
 */
public class TestHeap002 {
    byte[] bytes = new byte[new Random().nextInt(1000 * 1000)];

    public static void main(String[] args) {
        List list = new ArrayList<>();

        while (true) {
            list.add(new TestHeap002());  //创建大对象
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
