package Fundation.Thread;

/**
 * Created：Jeffrey
 * date   ：2020/6/25 17:01
 */
public class Thread001 extends Thread {
    //新的线程里执行:重写的run方法！！！
    @Override
    public void run() {
        synchronized (new Object()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread001");
    }

    public static void main(String[] args) {
        ClassLoader.getSystemClassLoader().getResourceAsStream("");

    }
}
