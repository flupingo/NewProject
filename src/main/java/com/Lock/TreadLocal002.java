package com.Lock;

/**
 * Created：Jeffrey
 * date   ：2021/9/1 15:21
 */
public class TreadLocal002 {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String co) {
        content = co;
    }

    public static void main(String[] args) {

        ThreadLocal001 t = new ThreadLocal001();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                synchronized (t) {
                    t.setContent(Thread.currentThread().getName()); //设值
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "===>" + t.getContent()); //取值
                }
            });
            thread.start();
        }


    }
}
