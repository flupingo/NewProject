package Fundation.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created：Jeffrey
 * date   ：2021/6/27 15:14
 */
public class TestProxy001 {
    public static void main(String[] args) throws Throwable {
        Star realStar = new Star() {
            @Override
            public void sing(String song) {
                System.out.println(song);
            }

            @Override
            public void makeMoney() {
                System.out.println("我在赚钱！！！");
            }
        };

        //1.自己创建的代理对象，所有方法都会被增强。
        // 2.AOP/事务是对指定的方法做增强。
        Star star = (Star) Proxy.newProxyInstance(TestProxy001.class.getClassLoader(), new Class[]{Star.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("==");
                return method.invoke(realStar, args);
            }
        });
        star.sing("我在唱歌！！！");

        star.makeMoney();
    }

    static class inner {
        String get() {
            return "innnner";
        }
    }

}
