package Thread;

/**
 * Created：Jeffrey
 * date   ：2019/12/5 15:30
 */
public class Rabbit extends Thread {
    @Override
    public void run() {  //重写run
        for (int i = 0; i < 5; i++) {
            System.out.println("兔子线程在运行="+i);
        }
    }
}
