package Fundation.Thread;



/**
 * Created：Jeffrey
 * date   ：2020/6/25 16:14
 */
public class ThreadTest001 {
    public static void main(String[] args) {
        Thread thread=new Thread001();
        thread.start();//执行重写后的run()方法，如果没有重写就执行Thread本身的（没有线程创建）

    }
}
