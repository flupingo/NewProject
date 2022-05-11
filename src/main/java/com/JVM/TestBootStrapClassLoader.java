package com.JVM;

import Fundation.Dog;

/**
 * Created：Jeffrey
 * date   ：2021/7/22 6:59
 */
public class TestBootStrapClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader(); //Launcher$AppClassLoader
        System.out.println(classLoader);
        ClassLoader fa = classLoader.getParent();                      //Launcher$ExtClassLoader
        ClassLoader fa01 = fa.getParent();                             //null
        Dog.class.getClassLoader();
        get();
    }

    static void get() {
        int i = 1 / 0;
    }
}
