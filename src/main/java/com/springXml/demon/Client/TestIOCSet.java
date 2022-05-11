package com.springXml.demon.Client;

import com.springXml.demon.Service.IOCSetUserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 16:42
 */
public class TestIOCSet {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/bean.xml");
        IOCSetUserServiceImpl ioc = (IOCSetUserServiceImpl) classPathXmlApplicationContext.getBean("IOCSetUserServiceImpl");
        System.out.println(ioc.toString());
    }
}
