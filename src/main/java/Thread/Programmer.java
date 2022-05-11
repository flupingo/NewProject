package Thread;

/**
 * Created：Jeffrey
 * date   ：2020/1/2 19:58
 */
public class Programmer implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("一边敲代码");
        }
    }
}
