package com.springIOC.demonAnn.Service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created：Jeffrey
 * date   ：2021/9/2 6:20
 */

@Component
public class SpringCircle implements ApplicationContextAware {
    private ApplicationContext application;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        application = applicationContext;
    }
}
