package Fundation.DesignTemp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created：Jeffrey
 * date   ：2021/8/28 21:11
 */
public class Test001 {
    public static void main(String[] args) {
        //策略模式
        Integer[] ints = {1, 3, -1};
        Arrays.sort(ints, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });


    }
}
