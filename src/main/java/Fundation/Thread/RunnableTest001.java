package Fundation.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created：Jeffrey
 * date   ：2020/6/25 17:08
 */
public class RunnableTest001 {
    public  static ExecutorService EXECUTOR= Executors.newFixedThreadPool(10);
    public static void main(String[] args) {

        Thread thread001=new Thread(()-> System.out.println("实现run方法"));
        thread001.start();

        //异步执行runnable
        CompletableFuture<Void>completableFuture=CompletableFuture.runAsync(()->System.out.println("===Runnable==="),EXECUTOR);





        //匿名内部类
        final Thread thread1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("run"); //start0（）执行重写的run()
            }
        });
        thread1.getName();
        System.out.println("11");
        thread1.start();

        Thread thread = new Thread(new Thread001());
        thread.start();




}
}
