package Reflection;

import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created：Jeffrey
 * date   ：2021/6/7 8:45
 */
public abstract class TestReflect001<V> {
    public static void main(String[] args) {
        //Class类型
        try {
            Class<?> cl = innerClass.class;
            Annotation[] annotations = cl.getAnnotations();
            for(Annotation annotation:annotations){
                annotation.annotationType();

            }


            //method/field--只有public的才可以获取
            Method[] methods = cl.getMethods();
            Field field = cl.getField("age");


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    abstract V get(V a);

    @Component
    static class innerClass extends TestReflect001<String> {
        public String age;

        @Override
        public String get(String a) {
            return null;
        }


    }

}
