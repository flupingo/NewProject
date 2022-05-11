package Fundation.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created：Jeffrey
 * date   ：2020/6/20 21:51
 */
public class StarHandle implements InvocationHandler {
    private Star realStar;//真实角色

    public StarHandle(Star realStar) {
        this.realStar = realStar;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法增强
        System.out.println("歌曲宣传，运营人设");
        //真实对象方法
        method.invoke(realStar, args);
        System.out.println("收钱！");
        return null;
    }
}
