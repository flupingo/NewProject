package com.Lock;

import io.netty.util.concurrent.CompleteFuture;
import jodd.util.ObjectUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created：Jeffrey
 * date   ：2022/3/3 12:02
 */
public class TestAsync {
    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {
        System.out.println("===main开始执行===");
//        Future future01 = executor.submit(() -> System.out.println(""));
//        future01.get();

        //1.无返回值
//        CompletableFuture<Void>completableFuture=CompletableFuture.runAsync(()->{
//            System.out.println("Runnable开始！！！");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Runnable完成");
//        },executor);

        //2.supply
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(1000);
//                System.out.println("第一个线程执行完成！！！");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
////            int a = 2 / 0;
//            return "12";
        /**
         * 回调：紧跟上面的线程执行，没有返回值，只是感知！
         */

//        }, executor).whenComplete((result, exception) -> {
//            try {
//                Thread.sleep(1000);
//                if (null != exception) {
//                    System.out.println("异常：" + exception);
//                } else {
//                    //只能获取异常信息，无法处理
//                    System.out.println("获取上一个线程结果：" + result);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).exceptionally(exception -> "异常数据");//处理异常？？？
//        System.out.println("异步执行结果：" + future.get());


        /**
         * 3.回调对线程执行结果进一步处理
         */
//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "12", executor)
//                .handle((result, exception) -> {
//                            if (result != null) {
//                                return "数据正常";
//                            } else {
//                                return "数据有误";
//                            }
//                        }
//                );
//        System.out.println("异步执行结果：" + future1.get());


        CompletableFuture future02 = CompletableFuture.supplyAsync(() -> "12", executor);

        //等3个任务中最慢的执行完，并行的等待，没有阻塞！
        CompletableFuture future03=CompletableFuture.allOf(future02,null,null);



        future03.supplyAsync(null,executor);


        executor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        FileInputStream inputStream = null;
        try {

            inputStream.read();





        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("===main执行完成！！！===");
        executor.shutdown();
    }
}
