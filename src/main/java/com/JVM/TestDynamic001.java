package com.JVM;

import Fundation.InnerClass.Interface003;
import com.springIOC.demonAnn.Entity.AnnUser;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created：Jeffrey
 * date   ：2021/7/26 21:32
 */
public class TestDynamic001 implements Interface003 {
    @Autowired
    AnnUser annUser;

    public String name;

    static int age = 1;
    static final int age1 = 0;

    static void get() {

    }

    public static void main(String[] args) {

        System.out.println("1");
    }

    public void AnimalTest(Animal animal, Hunterable hunterable) {
        annUser.getName();
        TestDynamic001.get();
        int a = TestDynamic001.age;
        int b = TestDynamic001.age1;
        Animal animal1 = new Animal();
        animal1.eat();
        animal.eat();
        hunterable.hunt();
        System.out.println("123"+"222");

        Test test = () -> System.out.println("");
        Test test1 = new Test() {
            @Override
            public void tt() {
            }
        };
    }

    @Override
    public String sing() {
        return null;
    }


    interface Test {
        void tt();

    }

    class Cat extends Animal implements Hunterable {
        Cat() {
            super();
        }

        @Override
        public void hunt() {
            System.out.println("猫拿耗子");
        }

        public void eat() {
            System.out.println("猫吃鱼");
        }

    }

    class Dog extends Animal implements Hunterable {
        @Override
        public void hunt() {
            System.out.println("狗拿耗子，多管闲事");
        }

        @Override
        void eat() {
            System.out.println("狗吃骨头");

        }
    }


}
