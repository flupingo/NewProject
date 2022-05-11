package com.springXml.demon.Client;

import com.springXml.demon.Service.IOCUserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 16:23
 */
public class TestIOCConstr {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring/bean.xml");
        IOCUserServiceImpl ioc=(IOCUserServiceImpl)classPathXmlApplicationContext.getBean("IOCUserServiceImpl");

    }
}
