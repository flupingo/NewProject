package Fundation.Collection;

import java.util.*;

/**
 * Created：Jeffrey
 * date   ：2021/9/19 17:11
 */
public class TestArray003 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(1);
        list.iterator();
        list.add(1, 3);
//        list.set(1,2);
//        list.remove(1);
//        list.size();

        Object[] objects = {};
        int a = objects.length;
        String b = "12";
        int c = b.length();

        LinkedList linkedList = new LinkedList();
//        if(linkedList.size())
        linkedList.add(0, 2);
        linkedList.add(3);
        linkedList.add(4);

        Set set = new HashSet();


        HashMap<String, Object> s = new HashMap();
        s.put("1", 2);
        s.put("2", 3);
        s.put("4", 1);

//        for (String k : s.keySet()) {
//            if (k == "2") {
//                s.remove(k);
//            }
//            System.out.println(k);
//        }
//
//
//        for (Object o:linkedList){
//            linkedList.remove(o);
//
//        }




        Set<Map.Entry<String, Object>> set1 = s.entrySet();
        Iterator<Map.Entry<String, Object>> i = set1.iterator();
        while (i.hasNext()) {
            Map.Entry entry = i.next();
            if (entry.getKey() == "2") {
                i.remove();
            }
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println(i);


//        System.out.println(list);


    }


    static  class Iter implements Iterator{

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
