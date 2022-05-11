package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created：Jeffrey
 * date   ：2021/6/26 15:41
 */
public class TestReflect002 {
    String name;
    public static void main(String[] args) {
        try {
            Constructor constructor= TestReflect002.class.getConstructor(String.class);
            try {
                constructor.newInstance();


            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }


    public TestReflect002(String name) {
        this.name="";
    }
}
