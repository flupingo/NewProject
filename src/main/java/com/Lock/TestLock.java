package com.Lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created：Jeffrey
 * date   ：2022/4/9 15:35
 */
public class TestLock implements Lock {
    private Sync sync;

    public TestLock() {
        setSync(true);
    }

    public TestLock(boolean flag) {
        setSync(flag);
    }

    public void setSync(boolean flag) {
        sync = flag ? new Sync.FailSync() : new Sync.NonFailSync();
    }


    @Override
    public void lock() {
        sync.acquire(1);


    }


    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }


    static abstract class Sync extends AbstractQueuedSynchronizer {


        public static class FailSync extends Sync {

        }

        public static class NonFailSync extends Sync {
        }
    }

    public static void main(String[] args) {
        TestLock testLock = new TestLock();
        testLock.lock();


    }


    public static class Semaphere001 implements Lock {
        public Sync001 sync001; //组合锁

        public Semaphere001(int permit) {
//            sync001=new Sync001.FailSync();
            sync001.setPermits(permit);

        }

        protected void acquire(int arg) throws InterruptedException {
            sync001.acquireSharedInterruptibly(arg);
        }


        public static void main(String[] args) {
            Semaphere001 semaphere001 = new Semaphere001(1);


        }


        abstract static class Sync001 extends AbstractQueuedSynchronizer {

            //子类开放方法，对象不能直接调用protect方法
            public void setPermits(int permits) {
                setState(permits);
            }

            abstract public void getLock(int count);


            public static class FailSync extends TestLock.Sync {
                public FailSync() {
                }

                //
                public int tryAcquireShared(int arg) {
                    while (true) {
                        int result = getState() - arg;
                        if (result < 0 || (result > 0 && compareAndSetState(getState(), result))) {
                            return result;
                        }
                    }
                }
            }

            public static class NonFailSync extends TestLock.Sync {
                //自旋抢锁
                public int tryAcquireShared(int arg) {
                    while (true) {
                        int result = getState() - arg;
                        if (result < 0 || (result > 0 && compareAndSetState(getState(), result))) {

                        }
                    }
                }
            }
        }

        @Override
        public void lock() {

        }

        @Override
        public void unlock() {

        }

        @Override
        public void lockInterruptibly() throws InterruptedException {

        }

        @Override
        public boolean tryLock() {
            return false;
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public Condition newCondition() {
            return null;
        }
    }

}
