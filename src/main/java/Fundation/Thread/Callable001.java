package Fundation.Thread;

import java.util.concurrent.Callable;

/**
 * Created：Jeffrey
 * date   ：2020/6/25 17:44
 */
public class Callable001 implements Callable {
    public Object call() throws Exception {
        System.out.println("Callable001");
        return null;
    }
}
