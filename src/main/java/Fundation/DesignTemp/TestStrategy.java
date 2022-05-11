package Fundation.DesignTemp;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created：Jeffrey
 * date   ：2022/4/17 11:09
 */
public class TestStrategy {
    private static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    static {
        concurrentHashMap.putIfAbsent("1", 2);
        concurrentHashMap.putIfAbsent("2", 3);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 3; i++) {
            System.out.println(concurrentHashMap.get(String.valueOf(i)));

        }

    }
}
