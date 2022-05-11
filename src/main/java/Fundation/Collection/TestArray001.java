package Fundation.Collection;

import java.util.*;

/**
 * Created：Jeffrey
 * date   ：2021/7/12 10:16
 */
public class TestArray001 {
    public static void main(String[] args) {
        //1.集合容量可变
        //2.提供一系列操作方法：增删改查!
        //====ArrayList=====

        Object[] objects = new Object[10];
        Object ob = objects[0];

        int aa = objects.length;

        ArrayList list12 = new ArrayList(1);
        list12.add(1);
        list12.add(2);
        list12.add(3);
        list12.add(3);
        list12.add(4);
        list12.remove(1);

        ArrayList<Integer> list1 = new ArrayList(10);
        list1.add(1);
        list1.get(0); //indexOfBoundException ！！


        List list = new ArrayList();  //初建的list的大小是0，只有添加元素后，大小才会变化
        list.add(111);
        list.add(0, 1);
        list.set(1, 2);
        list.add(1);    //add(new Integer(1))
        list.remove(1); //删除



        //====LinkedList=====
        List linkedList = new LinkedList();
        //添加
        linkedList.add(1);
        linkedList.get(0);
//        linkedList.add(2, 3);
        //删除
//        linkedList.remove(1);
        Object o = ((LinkedList) linkedList).remove();//默认删除第一个？？？

        //====HashSet=====
        Set set = new HashSet<>();
        set.add(1);
        //遍历？？？

        //====HashMap=====
        Map map = new HashMap();
        map.put(1, 2);
        map.put(1, 4);
        Object obj = map.put(1, 2);
        System.out.println(map.get(1));

        //====LinkedHashSet=====
        Set linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(1);
    }


    public static class link {
        Node head;

        public static void main(String[] args) {
            link link = new link();
            Node pre = link.head.next.pre;

        }

        public class Node {
            Object value;//节点存的值
            Node pre;
            Node next;

        }


    }
}
