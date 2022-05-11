package com.springIOC.demonAnn.Client;

import com.springIOC.demonAnn.Service.AnnUserServiceImpl;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 17:41
 */
public class TestAnn {
    public static void main(String[] args) {
        //1.和xml获取beanFactory一样
        ClassPathXmlApplicationContext cl=new ClassPathXmlApplicationContext("spring/bean.xml");
        cl.refresh();
        AnnUserServiceImpl an=(AnnUserServiceImpl)cl.getBean("annUserServiceImpl");
        an.add();
    }
}
