package com.SpringAOP.Utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * AOP应用-日志
 * Created：Jeffrey
 * date   ：2020/7/2 22:31
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class Logger {
    //定义切点:对哪些方法进行加强
    @Pointcut("execution(void *..AccountServiceImpl.*(..))")
    public void pointCut() {
    }

    //打印日志，计划让其在切入点方法执行前执行
    @Before("pointCut()")
    void beforePrint() {
        System.out.println("前置通知！！！");
    }

    @After("pointCut()")
    void afterPrint() {
        System.out.println("后置通知！！！");
    }

    @AfterReturning
    void afterThrowingPrint() {
        System.out.println("异常通知！！！");
    }

    void afterPrintLog() {
        System.out.println("最终通知！！！");
    }


    @Around("pointCut()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {

        //1.执行方法直接有现成的：pjp.proceed()
        //2.获取切入点的方法名，注解，参数等信息，用于业务判断
        Object object = pjp.getTarget();     //目标对象
        Object[] args = pjp.getArgs();       //传参
        String className = pjp.getTarget().getClass().getName();//被代理类名
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        Annotation[] annotations = method.getAnnotations();


        Class c = pjp.getClass();  //获取class对象


        //jeff 通过对方法名判断，进一步指定不同的增强逻辑


        Object obj = null;
        try {
            System.out.println("环绕前置！！！");
            obj = pjp.proceed(args);//被增强方法调用
//            pjp.proceed()
            System.out.println("环绕后置！！！");
        } catch (Throwable throwable) {
            System.out.println("异常！！！");
            throwable.printStackTrace();
        } finally {
            System.out.println("环绕最终通知");
            return obj;
        }
    }

}
