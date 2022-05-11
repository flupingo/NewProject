package Fundation.Collection;

import scala.collection.mutable.HashTable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created：Jeffrey
 * date   ：2021/8/19 15:00
 */
public class TestHashMap {
    public static void main(String[] args) {
        int i = 1 & 2;
        System.out.println(i);
        ConcurrentHashMap concurrentHashMap001=new ConcurrentHashMap();
        concurrentHashMap001.putIfAbsent(1,2);
        concurrentHashMap001.putIfAbsent(1,3);

        System.out.println(concurrentHashMap001);


        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1, 2);
        linkedHashMap.put(1, 2);

        HashSet hashSet = new HashSet<>();
//        hashSet.add(1);
//        hashSet.add(1);

        //扩容机制
        for (int j = 0; j <= 16; j++) {
            hashSet.add(new Dog(j));
        }

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Dog dog = new Dog(1);
        Dog dog1 = new Dog(2);
        linkedHashSet.add(dog);
        linkedHashSet.add(dog1);

        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);

        linkedHashMap.get(1);


        TreeSet treeSet01 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo((String) o2);
            }
        });

        TreeSet treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);

        ArrayList arrayList = new ArrayList();

        Hashtable hashtable = new Hashtable();
        hashtable.put(1, 2);


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(new Thread());

        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        linkedBlockingDeque.poll();


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(1, 2);

        Vector vector = new Vector();
        vector.add(2);
    }

    static class Dog {
        public Dog(int age) {
            this.age = age;
        }

        int age;
    }

}
