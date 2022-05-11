package Fundation.Thread;

import org.jboss.netty.channel.socket.Worker;

import java.util.concurrent.*;

/**
 * Created：Jeffrey
 * date   ：2021/6/13 15:48
 */
public class ThreadPool001 {
    public static void main(String[] args) {
        //工厂方法
        ExecutorService executorService = Executors.newFixedThreadPool(3);


//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("===");
//                System.out.println("===");
//            }
//        });


//        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 3, 100000, TimeUnit.SECONDS,
//                new SynchronousQueue<>(), new ThreadPoolExecutor.AbortPolicy());


        ExecutorService executorService1=new ThreadPoolExecutor(2,4,100L,TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));


        executorService1.submit(()->System.out.println("1"));

        for (int i=0;i<100;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("==11111=");
                    try {
                        Thread.sleep(1000000000000000000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();

//        pool.shutdown();


    }
}
