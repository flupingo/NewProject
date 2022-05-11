package Fundation.ProxyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created：Jeffrey
 * date   ：2020/7/2 20:56
 */
public class Producer {
    public void get() {
        System.out.println("get");
        eat();
    }

    public void eat() {
        System.out.println("eat");
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        try {
            Method method = producer.getClass().getMethod("get");
            method.invoke(producer);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}
