package com.Completable;

import Fundation.Dog;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.*;

/**
 * Created：Jeffrey
 * date   ：2022/3/30 10:57
 */
public class TestCompletable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(12);
        Future future = (executor).submit(() -> {
            System.out.println("====");
            Thread.sleep(10000);
            return 1;
        });
        future.get();  //awaitDone()等任务执行完成才停止阻塞

//        System.out.println("!!!");

        CompletableFuture.runAsync(()->System.out.println(""));
        CompletableFuture<Dog> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("!!!");
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new Dog("dog");
        });

        completableFuture.get();

        CompletableFuture<Void> completableFuture1 = completableFuture.thenAcceptAsync((a) -> { //无线程池执行
            System.out.println(a);
        });

        completableFuture.thenAccept(null);
        completableFuture.thenRun(null);


//        completableFuture.thenAcceptAsync(null);


        System.out.println("！！！" + completableFuture1);

        completableFuture1.thenAcceptAsync((a) -> System.out.println());//有线程池去执行


        completableFuture.thenAcceptAsync((res) -> System.out.println(res));


        Thread.sleep(100000000);


        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        threadLocal.set(null);








    }


    @Data
    @AllArgsConstructor
    static class Dog {
        private String name;

    }

    static  class handler implements HandlerInterceptor{
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            request.getSession();


            return false;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        }
    }
}
