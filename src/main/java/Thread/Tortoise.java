package Thread;

/**
 * Created：Jeffrey
 * date   ：2019/12/5 15:49
 */
public class Tortoise extends Thread {  //乌龟
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("乌龟线程在运行=" + i);
        }
    }
}
