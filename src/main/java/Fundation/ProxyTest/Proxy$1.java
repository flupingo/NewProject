package Fundation.ProxyTest;

import java.lang.reflect.InvocationHandler;

/**
 * Created：Jeffrey
 * date   ：2022/4/25 17:27
 */
public class Proxy$1 implements Star {
    private InvocationHandler starHandler; //通过组合处理器，来实现方法增强
    Star star;


    public Proxy$1(InvocationHandler starHandler) {
        this.starHandler = starHandler;
    }

    public void sing(String song) {
        try {
            starHandler.invoke(star, this.getClass().getMethod("sing"), new Object[]{song});
            return;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    //执行未增强方法的是:普通bean？？？？？？
    public void makeMoney() throws Throwable {
        star.sing("");
    }

    public static void main(String[] args) {
        Proxy$1 proxy$0 = new Proxy$1((proxy, method, args1) -> {
            method.invoke(proxy, args);
            System.out.println("===");
            return null;

        });
        proxy$0.sing("");

    }
}
