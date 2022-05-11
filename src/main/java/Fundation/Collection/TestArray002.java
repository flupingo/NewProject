package Fundation.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2021/7/14 10:33
 */
public class TestArray002 {
    public static void main(String[] args) {
        List list = TestReflect003();
//        List list = TestReflect002();

        System.out.println(list);


    }

    public static List TestReflect003() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        List list = new ArrayList();
        Collections.addAll(list, arr);
        return list;
    }

    public static List TestReflect002() {
        String[] arr = new String[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+"";
        }
        List list = new ArrayList();
        Collections.addAll(list, arr);
        return list;
    }
}
