package com.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2022/5/1 16:12
 */
public class TestOOM {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        while (true){
            list.add("12");
        }

    }
}
