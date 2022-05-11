package Fundation.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created：Jeffrey
 * date   ：2020/12/29 22:01
 */
//自定义注解
@Target(value = {ElementType.METHOD, ElementType.TYPE,ElementType.FIELD})//作用目标
@Retention(value = RetentionPolicy.RUNTIME)            //生命周期
public @interface AnnotationInstance {
    String name() default "yang";

    int age();

    String[] hobby();



}
