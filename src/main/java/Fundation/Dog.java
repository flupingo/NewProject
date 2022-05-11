package Fundation;

import org.springframework.stereotype.Component;

/**
 * Created：Jeffrey
 * date   ：2020/6/17 14:26
 */
@Component
public class Dog implements Animal {
    public void sing(Animal animal) {

    }

    @Override
    public void test() {
        System.out.println("dog");
    }

//    public static void main(String[] args) {
//        Dog []dogs=new Dog[2];
//
//    }
}
