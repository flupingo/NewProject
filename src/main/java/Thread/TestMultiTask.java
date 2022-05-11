package Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created：Jeffrey
 * date   ：2021/6/5 20:36
 */
public class TestMultiTask {
    public static void main(String[] args) {
        String a = "hello";
        Map<Object, Object> map = new HashMap<>();

        //查询一周数据
        for (int i = 1; i < 6; i++) {
            String b = "yangJie";
            final int day = i;
            ThreadTask threadTask = new ThreadTask() {
                @Override
                public void process() {
                    //查询每天数据
                    System.out.println("今天是周" + getResultFromEveryDay(day) + "！！！");
                }
            };
            map.put(i, threadTask); //0-5，6个任务！！！
        }

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2,
//                100, null, null);

        ExecutorService executorService = Executors.newFixedThreadPool(12);


        //执行5个任务
        for (Object s : map.values()) { //Set
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    ThreadTask threadTask = (ThreadTask) s;
                    threadTask.process();
                    System.out.println();
                }
            });
        }


    }

    public static String getResultFromEveryDay(int i) {
        switch (i) {
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            default:
                return "-1";
        }


    }

}
