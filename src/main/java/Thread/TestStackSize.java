package Thread;

import java.util.ArrayList;

/**
 * Created：Jeffrey
 * date   ：2020/1/15 21:19
 */
public class TestStackSize {
    public static void main(String[] args) {
        Thread thread=new Thread();
        thread.start();
        ThreadGroup threadGroup=Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName());
        System.out.println(threadGroup.activeCount());
        Thread[]threads=new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);


    }
}
