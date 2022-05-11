package com.springIOC.demonAnn.Listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created：Jeffrey
 * date   ：2022/3/27 13:44
 */

public class PublishEvent {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.publishEvent(new ContextRefreshedEvent(applicationContext));

    }

}
