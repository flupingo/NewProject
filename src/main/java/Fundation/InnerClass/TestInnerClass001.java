package Fundation.InnerClass;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Created：Jeffrey
 * date   ：2021/6/10 8:39
 */
public class TestInnerClass001 {
    public static void main(String[] args) {
        Map<Integer, Object> tasks = new HashMap<>();
        for (int i = 0; i < 6; i++) {

            //i是可变的，给别的变量赋值
            Integer a = i;
            TaskInterface001 task = new TaskInterface001<Map<Integer, Object>>() {
                @Override
                public Map<Integer, Object> process() {
                    Map<Integer, Object> map = new HashMap();
                    map.put(a, "周几");
                    return map;
                }
            };
            tasks.put(i, task);
        }

        for (int i = 0; i < tasks.size(); i++) {
            final int i1 = i;
            Executors.newFixedThreadPool(10).submit(new Runnable() {
                @Override
                public void run() {
                    tasks.get(i1);


                }
            });

        }

    }
}
