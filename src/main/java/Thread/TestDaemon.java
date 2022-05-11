package Thread;

/**
 * Created：Jeffrey
 * date   ：2020/1/15 22:31
 */
public class TestDaemon {
    public static void main(String[] args) {
        //1.new状态
        Thread thread = new Thread() {  //匿名类
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("run()在执行！！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //2.runnable准备状态-->running -->dead -->block
        thread.setDaemon(true);  //守护线程会随
        thread.start();
        System.out.println(Thread.currentThread().getName());

//        Thread thread1 = new Thread(() -> {
//            Thread thread2 = new Thread(() -> {
//
//            });
//
//        });
    }
}
