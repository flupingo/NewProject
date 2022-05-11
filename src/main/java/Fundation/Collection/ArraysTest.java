package Fundation.Collection;

import Fundation.HandleData;
import Fundation.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created：Jeffrey
 * date   ：2020/6/24 10:23
 */
public class ArraysTest {
    public static void main(String[] args) {
        Integer[] aaa = new Integer[12];
        aaa[0] = 23;
        aaa[1] = 12;

        List<Integer> list22 = new ArrayList();
        list22.add(12);
        list22.add(23);
        List<Integer> collect = list22.stream().filter((a) -> a > 20).collect(Collectors.toList());
        System.out.println(collect);

        ArrayList<Map<String, Integer>> maps = new ArrayList<>();
        Map map = new HashMap();
        map.put("count", 12);
        maps.add(map);
        Map map2 = new HashMap();
        map2.put("count", 23);
        maps.add(map2);
        Map map1 = new HashMap();
        map1.put("count", 14);
        maps.add(map1);

        Collections.sort(maps, (a, b) -> {
            Integer a1 = a.get("count");
            Integer b1 = b.get("count");


//            return  a1.compareTo(b1);
            if (a1 > b1) {
                return 1;
            } else {
                return -1;
            }
        });

        System.out.println(maps);

        System.out.println(new Integer(-1).compareTo(new Integer(1)));

        List list = new ArrayList();
//        List list1=new ArrayList(12);  //指定容量
        list.add(1);
        list.add(2);
        System.out.println(list);

        int[] ints = {1, 2, 3};
        System.out.println(ints);

//        testArrays();
//        testCollections();
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
    }

    static void testArrays() {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * i;
        }

//        arr[5]=2;
//        System.out.println(arr[2]);

        //1.静态初始化
        int[] brr = {1, 2, 3};
        int[] drr = new int[]{1, 2, 3};
//        System.out.println(drr[2]);
        User[] crr = {new User("zhang")};

//        for(int i:brr){
//            System.out.println(i);
//        }

        int[] err = new int[4];
        System.arraycopy(arr, 0, err, 1, 2);
//        for(int i:arr){
//            System.out.println(i);
//        }
//        for(int i:err){
//            System.out.println(i);
//        }


        Arrays.asList(err);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };

        Integer[] i = new Integer[12];
        Arrays.sort(i, comparator);

        Arrays.sort(new Integer[12], (a, b) -> 1);

        Collections.sort(new ArrayList<Integer>(), null);

        Integer aa = 1;
        aa.compareTo(2);


        Arrays.sort(err);
//        System.out.println(err);
//        System.out.println(Arrays.toString(err));

        User[][] frr = new User[2][];
        frr[0] = new User[]{new User("1"), new User("2")};
        frr[1] = new User[]{new User("1"), new User("2"), new User("3")};

//        frr[0]={new User("1"),new User("2")};//二维数组不能静态初始化
//        frr[0][0]=new User("zhangsan");
//        frr[0][1]=new User("lisi");
//        frr[1][0]=new User("wangwu");
        System.out.println(frr + "====");
        System.out.println(Arrays.toString(frr[0]));
        System.out.println(frr[1]);
    }

    static void testCollections() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(-10);

        //1.默认从小到大排序
        Collections.sort(list);
        System.out.println(list);

        //2.自定义排序规则？？？？？


        List<Map<String, Object>> mapList = new ArrayList<>(); //a.排序数据
        mapList.add(null);
        mapList.add(null);
        mapList.add(null);

        testSelfSort(mapList, new HandleImplement());          //b.排序方法
    }


    static void testSelfSort(List<Map<String, Object>> mapList, HandleData handleData) {
        Collections.sort(mapList, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {  //o1,o2是List里的元素，类型是Map的，
                Integer ke1 = 0;
                Integer ke2 = 0;
                ke1 = handleData.selfSort(o1);
                ke2 = handleData.selfSort(o2);

                //Integer实现了Comparable接口，有compareTo()方法!
                return ke1.compareTo(ke2);
            }
        });
    }


    static class HandleImplement implements HandleData {
        @Override
        public Integer selfSort(Map<String, Object> map) {
            Integer i = 0;
            return i;
        }
    }

    //实现Comparable，自定义比较大小方法
    class compareImplement implements Comparable {
        @Override
        public int compareTo(Object o) {

            return 0;
        }
    }


}


