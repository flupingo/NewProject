package Fundation.Collection;

import scala.collection.mutable.HashTable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created：Jeffrey
 * date   ：2021/8/28 11:57
 */
public class ArraysTest001 {
    public static void main(String[] args) {
        String[] strings = {"1", "a", "de"};

        List list = Arrays.asList(strings);
        list.add(1);
        System.out.println(list.get(2));


        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put(1,2);





    }
}
