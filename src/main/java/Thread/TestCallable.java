package Thread;

import java.util.concurrent.*;

/**
 * 通过Callable实现多线程
 * Created：Jeffrey
 * date   ：2020/1/9 22:19
 */
public class TestCallable {
    public static void main(String[] args) {

        //1.线程池方式实现
        //1.1创建线程==>父类ExecutorService指向子类ThreadPoolExecutor；  Executors工厂类
        ExecutorService executorService = Executors.newFixedThreadPool(2);//core和max都是2，返回 ThreadPoolExecutor 对象！！
//        ExecutorService executorService1=Executors.newSingleThreadExecutor();
//        ExecutorService executorService2=Executors.newCachedThreadPool();
//        ExecutorService executorService1=Executors.new;
        CallableInstance callableInstance01 = new CallableInstance();//创建线程

        ThreadPoolExecutor threadPoolExecutor=null;
        threadPoolExecutor.submit(callableInstance01);

        //(1)线程池submit执行线程,有返回值,传参是callable的实现类
        Future future = executorService.submit(callableInstance01);

        //(2)execute执行，无返回值,传参runnable的实现类
        executorService.execute(new Runnable() {
            public void run() { //重写Run（）
                System.out.println("execute实现多线程");
            }
        });

        executorService.shutdown();//关闭线程

//        executorService.invokeAll()
        //2.线程方式实现
        CallableInstance callableInstance02 = new CallableInstance();
        FutureTask futureTask = new FutureTask(callableInstance02);
        new Thread(futureTask).start();
        futureTask.run();

    }

    //静态内部类
    static class CallableInstance implements Callable<Integer> {
        //call()比Run()多了返回值，并且可以捕获异常！
        public Integer call() throws Exception {
            for (int i = 0; i < 5; i++) {
                System.out.println("一边敲代码");
            }
            return 1000;
        }

    }

}


