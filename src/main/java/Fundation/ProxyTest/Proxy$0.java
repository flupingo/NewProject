package Fundation.ProxyTest;

import Fundation.Dog;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟动态代理代理对象类---创建出来的内部类
 * Created：Jeffrey
 * date   ：2020/7/2 20:34
 */
public class Proxy$0 extends Proxy implements Star {  //和realStar实现了相同接口
    private InvocationHandler starHandle; //通过组合处理器，来实现方法增强

    public Proxy$0(InvocationHandler h) {
//        h=starHandle;
        super(h);   //Proxy父类的方法
    }

    //被增强的方法
    public void sing(String song) {
        try {
            //增强

            //业务
            starHandle.invoke(this, null, null);
            return;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    //普通方法调用
    public void makeMoney() {
        sing("歌曲");
    }


    public static void main(String[] args) {
        Proxy$0 proxy$0 = new Proxy$0((proxy, method, args1) -> {
            method.invoke(proxy, args);
            System.out.println("===");
            return null;

        });
        proxy$0.sing("");

    }
}
