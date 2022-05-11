package Fundation.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created：Jeffrey
 * date   ：2022/4/10 10:03
 */
public class Proxy001 implements Star {

    Handler handler;

    Star star;

    @Override
    public void sing(String song) throws Throwable {
        star.sing("");
        handler.invoke(star, star.getClass().getMethod("sing"), new Object[]{"song"});


    }

    @Override
    public void makeMoney() {

    }

    public static void main(String[] args) {
        Star star = new RealStar();
        Proxy.newProxyInstance(Proxy001.class.getClassLoader(), new Class[]{Proxy001.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(star, args);
            }
        });


    }

    public static class Handler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //方法执行
            method.invoke(proxy, args);
            //增强代码

            return null;
        }
    }

}
