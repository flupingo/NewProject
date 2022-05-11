package com.JVM;

/**
 * Created：Jeffrey
 * date   ：2021/7/15 9:19
 */
public class Stack001 {
    public static void main(String[] args) {
        int i = 2 + 3;
        Child child = new Child();              //4.先调用父类构造器，再调用子类构造器
        System.out.println(child.B);
    }

    static class Father {
        static int A = 1;                       //2.先加载父类：执行静态代码
        static {
            A = 2;
            System.out.println("Father静态方法");
        }
        public Father() {                       //4.先执行父类构造器
            System.out.println("Father构造器");
        }
    }

    static class Child extends Father {
        static int B = A;                       //1.加载Father，所以要先执行父类的静态代码
        static {                                //3.再加载子类静态代码
            System.out.println("Child静态方法");
        }
        public Child() {
            System.out.println("Child构造器"); //5.再执行子类构造器
        }
    }

}
