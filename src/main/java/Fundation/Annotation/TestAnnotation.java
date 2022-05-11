package Fundation.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created：Jeffrey
 * date   ：2021/6/28 14:26
 */
public class TestAnnotation {
    public static void main(String[] args) {
        Class c = InnerClass001.class;
        try {
            Method method = c.getDeclaredMethod("get");
            Annotation annotation = method.getAnnotation(AnnotationInstance002.class);
            String a = ((AnnotationInstance002) annotation).name();
            int b = ((AnnotationInstance002) annotation).age();
            System.out.println(a + b);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @AnnotationInstance002()
    static class InnerClass001 {
        @AnnotationInstance002(name = "zhang")
        private String name;

        @AnnotationInstance002(name = "ya")
        public void get() {

        }

    }


}
