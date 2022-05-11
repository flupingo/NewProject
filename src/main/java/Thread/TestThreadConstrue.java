package Thread;

/**
 * Created：Jeffrey
 * date   ：2020/1/15 20:48
 */
public class TestThreadConstrue {
    public static void main(String[] args) {
        //1.空构造,Run()不执行
        Thread thread = new Thread();
        //2.
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("=====");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //3.指定新增线程名字
        Thread thread2 = new Thread("thread名字");
        //4.指定线程名字和Target
        Thread thread3 = new Thread(new Thread() {
            @Override
            public void run() {
                System.out.println("线程名字=====");
            }
        }, "线程名字");
        thread.start();
        thread1.start();
        System.out.println(thread.getName());
        System.out.println(thread1.getName());
        System.out.println(thread2.getName());

    }


}
