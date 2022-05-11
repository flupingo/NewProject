package com.springXml.demon.Client;

import com.springXml.demon.Service.IOCComplexUserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 17:05
 */
public class TestIOComplex {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cl=new ClassPathXmlApplicationContext("spring/bean.xml");
        IOCComplexUserServiceImpl ic=(IOCComplexUserServiceImpl)cl.getBean("IOCComplexUserServiceImpl");
        System.out.println(ic.getProperties());
    }
}
