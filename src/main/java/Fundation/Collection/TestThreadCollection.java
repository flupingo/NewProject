package Fundation.Collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created：Jeffrey
 * date   ：2021/7/6 11:44
 */
public class TestThreadCollection {
    public static void main(String[] args) {

        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put(1,2);
        concurrentHashMap.get(1);

    }

}
