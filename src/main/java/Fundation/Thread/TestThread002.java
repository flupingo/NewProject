package Fundation.Thread;

/**
 * Created：Jeffrey
 * date   ：2021/7/13 15:23
 */
public class TestThread002 {
    public static void main(String[] args) {
        Thread thread=new Thread();
        Thread.yield();
        try {
            thread.join();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public  void syn(){
        synchronized (this) {
            int i=1;
        }


    }
}
