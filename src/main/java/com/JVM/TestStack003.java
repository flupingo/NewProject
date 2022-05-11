package com.JVM;

/**
 * Created：Jeffrey
 * date   ：2021/9/10 8:44
 */
public class TestStack003 {
    public static void main(String[] args) {
        A a = new B();
//        a.print();
//        print(a);

        int b = 0;
        int c = 0;
        int d = 0;
        for (int i = 0; i < 10; i++) {
            b = b++;
            d=b;
            System.out.println(d);
            c = ++c;
        }
        System.out.println(b);
        System.out.println(c);

    }


    static void print(A a) {
        a.print();
    }

    static class A {
        void print() {
            System.out.println("this is A");
        }
    }

    static class B extends A {
        void print() {
            System.out.println("this is B");
        }
    }


}
