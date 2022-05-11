package Reflection;

import Fundation.Cat;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created：Jeffrey
 * date   ：2022/2/12 20:58
 */
public class TestReflect004 {
    public static void main(String[] args) {
        try {
            Class clz = new Cat().getClass();
            Field field = clz.getField("test");


            Class clz1 = Cat.class;


            Constructor constructor = Cat.class.getConstructor();
            Object obj = constructor.newInstance();
            System.out.println(obj);

        } catch (NoSuchMethodException e) { //无此构造器
            e.printStackTrace();
        } catch (Exception g) {
            g.printStackTrace();
        }


    }
}
