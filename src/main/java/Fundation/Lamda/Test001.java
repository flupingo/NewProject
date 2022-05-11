package Fundation.Lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created：Jeffrey
 * date   ：2021/9/27 20:11
 */
public class Test001 {
    public static void main(String[] args) {
        Comparator comparator1 = new Comparator() {
            @Override
            public int compare(Object x, Object o2) {
                return 0;
            }
        };


        Comparator<Integer> comparator2 = (x, y) -> Integer.compare(x, y);


        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        Runnable runnable1 = () -> {
        };


        List list = new ArrayList<>();
        list.forEach(a -> {

        });

        Stream stream = list.stream();
//        stream.filter(t -> t > 3);


        int[] ar = new int[]{1, 2};
        Arrays.stream(ar);
        Stream.of(list);
        Stream.of(ar);

//        Stream.iterate()

    }
}
