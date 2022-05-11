package Reflection;

import java.lang.reflect.InvocationTargetException;

/**
 * Created：Jeffrey
 * date   ：2022/4/6 15:33
 */
public class Test002 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Test002 test002 = new Test002();
        test002.getClass().getConstructor().newInstance();


    }

    public void eat() {
    }

    public static void eat001() {
    }

}
