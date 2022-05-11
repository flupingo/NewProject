package Fundation.Thread;

import Fundation.InnerClass.TaskInterface001;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created：Jeffrey
 * date   ：2021/7/5 8:58
 */
public class ThreadPool002 {
    public static void main(String[] args) {
        Map<Integer, Object> map = new HashMap();
        for (int i = 0; i < 10; i++) {
            final int data = i;
            TaskInterface001<Integer> taskInterface001 = new TaskInterface001<Integer>() {
                @Override
                public Integer process() {
                    return data;
                }
            };
            map.put(i, taskInterface001);
        }

        Map<Integer, Future> resultMap = new HashMap();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(1,2,100,TimeUnit.SECONDS,new LinkedBlockingDeque<>(1));
//        Executors.newFixedThreadPool(1);

        for (Map.Entry<Integer, Object> entry : map.entrySet()) {
            Future future = executorService.submit(() -> {
                Thread.sleep(100000);
                TaskInterface001<Integer> taskInterface002 = (TaskInterface001) entry.getValue();
                return taskInterface002.process();
            });

//            future.get(100,TimeUnit.SECONDS);
            resultMap.put(entry.getKey(), future);
        }

        //从Future取数据，生成最终结果！！！
        Map resultMap1 = new HashMap();
        //遍历结果
        for (Map.Entry<Integer, Future> entry : resultMap.entrySet()) {
            try {
                int re = (Integer) entry.getValue().get(1000, TimeUnit.SECONDS);
                resultMap1.put(entry.getKey(), re);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }

        //=========队列类型========
        //1.LinkedBlockingDeque有序队列
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(1, 2, 100,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(1));
        //2.ArrayBlockingQueue 数组队列
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 3, 100,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        //3.SynchronousQueue 容量为1
        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(1, 3, 100,
                TimeUnit.SECONDS, new SynchronousQueue<>());


        //=======拒绝策略=======
//        Collections.
    }
}
