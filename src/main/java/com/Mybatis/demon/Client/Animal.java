package com.Mybatis.demon.Client;

/**
 * Created：Jeffrey
 * date   ：2020/7/16 17:17
 */
public abstract class Animal {
    //类似模板发方法
    //父类实现整体框架
    Animal createAnimal() {
        if (getType() > 1) {
            return new Cat();
        }
        return null;
    }

    //父类抽象部分细节
    abstract int getType();

    public class Cat extends Animal {
        //子类实现部分细节
        int getType() {
            return 0;
        }
    }

}