package Fundation.JDBC;


import Fundation.Animal;
import Fundation.Dog;
import org.apache.commons.io.input.BOMInputStream;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created：Jeffrey
 * date   ：2021/8/21 14:33
 */
public class Test001 {
    public static void main(String[] args) {
        ServiceLoader serviceLoader = ServiceLoader.load(Animal.class);
        Iterator iterator = serviceLoader.iterator();
//        iterator.next();

        Jedis jedis=new Jedis();
        jedis.set("","","nx","ex",1);



        Callable<String> callable1 = () -> {
            return "";
        };
        try {
            String a1 = callable1.call();
        } catch (Exception e) {
            e.printStackTrace();
        }


        ReentrantLock reentrantLock = new ReentrantLock();
        {
            reentrantLock.lock();
            //do service
            reentrantLock.unlock();
        }


        LinkedList linkedList = new LinkedList();

        HashMap hashMap = new HashMap();
        hashMap.put(1, 2);

        HashSet hashSet = new HashSet();
        hashSet.add(2);


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 100, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(100), new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                //do service
            }
        });

        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };

        Future future = threadPoolExecutor.submit(callable);


    }

    static void get() {
        Comparable comparable = new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };


        Comparator comparator = new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return 0;
            }
        };

        Dog dog;

        Collections.sort(new ArrayList<>(), comparator);


        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        Integer[] arr = new Integer[10];
        Arrays.sort(arr, comparator1);

        ArrayList list = new ArrayList();
        list.add(1);

        while (list.iterator().hasNext()) {
            list.iterator().next();
        }


        StringBuffer s = new StringBuffer();
        s.append("1");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");


        String a = new String();
    }

    static class class01 implements Iterator {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }
}
