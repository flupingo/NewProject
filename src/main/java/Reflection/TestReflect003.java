package Reflection;

import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2021/6/27 16:32
 */

public class TestReflect003 {
    private String name;

    public static void main(String[] args) throws Exception {
        try {
            Class c = TestReflect003.class;

            //获取非public字段
            Field field = c.getDeclaredField("name");
            System.out.println(field);
//            field.setAccessible(true);


            Method method = c.getMethod("get", String.class, Integer.class);
            method.setAccessible(false);
            method.invoke(new TestReflect003(), "wooo", 1);
            Annotation[] annotations = method.getAnnotations();
            System.out.println(annotations[0].annotationType());

            Constructor cc = c.getConstructor(String.class);
            Object o = cc.newInstance("zhangSan");

            System.out.println(o);


        } catch (Exception e) {
            throw new Exception();
        }

    }

    @RequestMapping("/request")
    public void get(String a, Integer b) {
        System.out.println(a + b);
    }

    public TestReflect003(String name) {

    }

    public TestReflect003() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        List list = new ArrayList();
        Collections.addAll(list, arr);

    }
}
