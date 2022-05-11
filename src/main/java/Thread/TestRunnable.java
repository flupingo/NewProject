package Thread;

/**
 * 静态代理：1.真实角色；
 *           2.代理角色；
 *           3.实现相同接口----代理角色可以实现真实角色所有的方法
 * Created：Jeffrey
 * date   ：2020/1/2 20:01
 */
public class TestRunnable {
    public static void main(String[] args) {
        Runnable programmer = new Programmer(); //【真实角色】1. Programmer实现Runnable接口，重写Run() ;2.programmer引用指向Programmer对象
        Thread thread = new Thread(programmer); //【代理角色】CallableThread实现Runnable接口，重写Run()；

        thread.start(); //start0()新开一个线程，调用Run()！！！！
        for (int i = 0; i < 5; i++) {
            System.out.println("一边吃饭");
        }

    }
}
