package Fundation.Thread;

import org.apache.hadoop.hbase.TableInfoMissingException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created：Jeffrey
 * date   ：2020/6/25 17:46
 */
public class CallableTest {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 100,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));
        Map<String, Object> map = new HashMap<>();

        new ThreadPoolExecutor(1,2,100, TimeUnit.SECONDS,new LinkedBlockingDeque<>(),
                new ThreadPoolExecutor.AbortPolicy());

        //多task创建
        for (int i = 0; i < 6; i++) {


        }


        Map map1 = new HashMap();
        //task在线程池执行
        for (Map.Entry entry : map.entrySet()) {

            Callable callable = new Callable() {
                @Override
                public Object call() throws Exception {
                    return null;
                }
            };
            Future future = threadPoolExecutor.submit(callable);
            map1.put("key", future);
        }

        HashMap hashMap=new HashMap();
        hashMap.put(1,2);


    }
}
