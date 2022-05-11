package Thread;

import org.redisson.Redisson;
import org.redisson.RedissonLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created：Jeffrey
 * date   ：2021/7/15 13:04
 */
public class TestReentrantLock {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true); //默认不公平锁 : sync=onFairSync
        //线程1加锁
        Thread thread001 = new Thread(() -> {
            reentrantLock.lock(); //锁的拥有者exclusiveOwnerThread = 调用线程
            //doService()
            System.out.println("thread001加锁完成");
            reentrantLock.unlock();

        });
        thread001.start();

        //线程2加锁
        Thread thread002 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.lock();
                //doService()
                System.out.println("thread002加锁完成");
//                reentrantLock.unlock();

            }
        });
        thread002.start();

        LockSupport.park();
        LockSupport.unpark(thread001);


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();


    }

    public void comPareAndSet() {

    }


    public void redissonLock() {
        Config config = new Config();
        config.useSingleServer().setAddress("192.168.0.102");
        RedissonClient redissonClient = Redisson.create(config);
        redissonClient.getReadWriteLock("key");




    }


}
