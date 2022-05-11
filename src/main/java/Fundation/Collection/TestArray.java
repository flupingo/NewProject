package Fundation.Collection;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

/**
 * Created：Jeffrey
 * date   ：2021/7/8 16:22
 */
public class TestArray {
    public static void main(String[] args) {
        Vector vector = new Vector();
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(2);
//        System.out.println(linkedList);
        linkedList.remove(1);
//        System.out.println(linkedList.get(1));

        List<String> list1 = Arrays.asList(new String[]{"1", "2"});
        List list = new ArrayList<>();
        list.add(12);
        list.add(13);

        list.addAll(linkedList);
//        System.out.println(list);
//        System.out.println(list.get(1));
//        System.out.println(list.indexOf(12));

        //TreeMap可以指定一个比较器
        TreeMap<Integer, Integer> treeMap = new TreeMap(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        treeMap.put(2, 3);
        treeMap.put(1, 2);
        treeMap.put(4, 2);
        treeMap.put(-100, 2);
        System.out.println(treeMap.keySet());

//        System.out.println(treeMap);

//
//        String name = "123";
//        System.out.println(name.hashCode());
//        Object o = new Object();
//        Object o1 = new Object();
//        System.out.println(o.equals(o1));
//
//
//        CollectionUtils.isNotEmpty(null);

        HashMap hashMap = new HashMap();
        hashMap.put(1,2);
        hashMap.entrySet();
        ArrayList arrayList=new ArrayList();



        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }






    class Test001 implements Iterable{

        @Override
        public Iterator iterator() {
            return null;
        }
    }
}
