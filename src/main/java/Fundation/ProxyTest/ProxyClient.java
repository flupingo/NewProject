package Fundation.ProxyTest;

import Fundation.Dog;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于接口动态代理
 * Created：Jeffrey
 * date   ：2020/6/20 22:08
 */
public class ProxyClient {
    public static void main(String[] args) throws Throwable {
        RealStar realStar = new RealStar();
        //1.创建InvocationHandler实现类，对方法增强
        StarHandle starHandle = new StarHandle(realStar);

        //===通过反射的方式获取实现接口(Star.class)并继承Proxy的子类，同时传入了invocationHandler！！！===
        //代理对象实现了接口的sing()方法即invoke()==>Proxy$0模拟生成的代理类
        Star proxyStar = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, starHandle);
        proxyStar.sing("小白船");  //调取invoke方法

        //2.通过匿名内部类方法 -- Returns an instance of a proxy class for the specified interfaces
        Star innerClassProxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("歌曲宣传，运营人设");

                //********真实对象realStar调用方法！！！所以嵌套调用，别的方法会不生效********
                method.invoke(realStar, args);
                System.out.println("收钱！");
                return null;
            }
        });
        innerClassProxy.sing("唱啥好呢");


        Star inner = new Star() {
            @Override
            public void sing(String song) {
                System.out.println("=====");
            }

            @Override
            public void makeMoney() {

            }
        };

        Star o = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                method.invoke(inner, args);
                System.out.println("增强");
                return null;
            }
        });
        o.sing("sdf");

    }

}
