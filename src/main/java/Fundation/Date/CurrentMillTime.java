package Fundation.Date;

/**
 * Created：Jeffrey
 * date   ：2021/6/27 10:08
 */
public class CurrentMillTime {
    public static void main(String[] args) {
        try {
            long time1 = System.currentTimeMillis();
            Thread.sleep(100);
            long t = System.currentTimeMillis();
            System.out.println(t - time1);



        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
