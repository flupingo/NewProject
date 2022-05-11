package Fundation.Comparable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * Created：Jeffrey
 * date   ：2021/8/12 19:00
 */
@Component
public class Comparator001 implements Comparable {
    public static void main(String[] args) {
        Comparator001 comparator001 = new Comparator001();
//        System.out.println(comparator001.compareTo(1));

        Comparator comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(comparator.compare(1, 2));

        Integer[] maps = new Integer[4];

        Arrays.sort(maps, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        try {
            Class c = Comparator001.class;
            Annotation[] annotations = c.getAnnotations();
            Constructor[] constructors = c.getConstructors();
            c.getConstructor(String.class);
            constructors[0].setAccessible(true);


        } catch (Exception e) {
            e.printStackTrace();
        }

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        ((ClassPathXmlApplicationContext) applicationContext).refresh();

        ((ClassPathXmlApplicationContext) applicationContext).getBeanFactory().getBean("1");


        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext();
        ((AnnotationConfigApplicationContext) applicationContext1).register();

    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
