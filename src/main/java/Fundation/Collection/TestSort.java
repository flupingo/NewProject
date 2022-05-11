package Fundation.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * Created：Jeffrey
 * date   ：2021/7/8 19:36
 */
public class TestSort {
    public static void main(String[] args) {
        ArrayList list11 = new ArrayList();
        list11.add(1);
        list11.add(2);
        list11.add(21);
        Collections.reverse(list11);
        System.out.println(list11);


        //引用类型
        String[] strings = new String[]{"1", "2"};
        List stringList = Arrays.asList(strings);

        int[] ints = new int[]{1, 2, 3, -1, 89};
        //int包装成Integer
        Integer[] integers = ArrayUtils.toObject(ints);

        List list = Arrays.asList(integers);

        //求最大值
        int a = 0;
        for (int i = 0; i < ints.length; i++) {
            if (a < ints[i]) {
                a = ints[i];
            }
        }
//        System.out.println(a);

        Collections.sort(list);
        Collections.sort(list, new Comparator<Integer>() {
            //实现比较器
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > 02) {
                    return 0;
                }
                return 1;
            }
        });


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
