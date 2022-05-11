package Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created：Jeffrey
 * date   ：2019/12/5 15:32
 */
public class TestThread {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        rabbit.start(); //加到线程组（ThreadGroup）里-->  group.add(this);
        tortoise.start();
//        Thread.sleep(1);

        ExecutorService executorService = Executors.newFixedThreadPool(1);


        HashMap hashMap = new HashMap(10);
        for (int i = 0; i < 10; i++) {
            int k = i;
            Callable callable = () -> {
                System.out.println(k);
                return eat(k);
            };

            hashMap.put(i, callable);
        }

        hashMap.entrySet().stream().forEach(
                i -> {
                    Map.Entry k = (Map.Entry) i;
                    k.getKey();
                    k.getValue();

                }

        );

    }

    public static int eat(int arg) {
        return arg + 1;
    }


}
