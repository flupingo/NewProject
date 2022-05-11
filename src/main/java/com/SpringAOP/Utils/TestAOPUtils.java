package com.SpringAOP.Utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created：Jeffrey
 * date   ：2021/6/5 21:47
 */
@Aspect
@Component
public class TestAOPUtils { //有点像工具，AOP的工具

    @Pointcut(value = "execution(void *..TestService.*(..))")
    public void start() {

    }

    @Before("start()")
    public void service() {
        System.out.println("service");
    };

//    @Around("start()")
    public void doSomething(ProceedingJoinPoint pjp) {
        try {
            System.out.println("===before====");
            Object[] objects = pjp.getArgs();
            Class class01 = pjp.getClass();
            class01.getAnnotations();

            Method[] methods = class01.getMethods();
            for (Method method : methods) {
               Annotation[] annotations= method.getAnnotations();


            }

            pjp.proceed(objects);
            System.out.println("===after====");


        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }



}
