package Fundation.Collection;

import scala.collection.mutable.HashTable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created：Jeffrey
 * date   ：2021/8/28 11:57
 */
public class ArraysTest001 {
    public static void main(String[] args) {

        LinkedList linkedList=new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(2,2222);
//        linkedList.add(0,4);
        System.out.println(linkedList.get(2));



        String[] strings = {"1", "a", "de"};
        System.out.println("master");
        System.out.println("local");
        System.out.println("local2");
        List list = Arrays.asList(strings);
        list.add(1);
        System.out.println(list.get(2));


        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put(1,2);





    }
}
