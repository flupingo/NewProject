package Fundation.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created：Jeffrey
 * date   ：2021/6/6 20:15
 */
public class TesInhance001 {

    static class RealSinger implements Star {
        void song() {
            System.out.println("start");
        }

        @Override
        public void sing(String song) {
            System.out.println("i like" + song);
        }

        @Override
        public void makeMoney() {

        }
    }

    public static void main(String[] args) throws Throwable {
        RealSinger realSinger = new RealSinger();
        //Returns an instance of a proxy class for the specified interfaces
        Star betterSinger = (Star) Proxy.newProxyInstance(TesInhance001.class.getClassLoader(), new Class[]{Star.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("i'm better then her!");
                method.invoke(realSinger, args);
                return null;
            }
        });
        betterSinger.sing("常回家看看");
    }


}
