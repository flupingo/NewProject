package Thread;

/**
 * Created：Jeffrey
 * date   ：2021/7/21 15:34
 */
public class TestDaemonThread {
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("222");
            }
        });
        thread1.start();


    }
}
