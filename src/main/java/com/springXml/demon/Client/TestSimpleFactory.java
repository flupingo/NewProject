package com.springXml.demon.Client;

import com.springXml.demon.DAO.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 15:39
 */
public class TestSimpleFactory {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring/bean.xml");
        UserDao userDao=(UserDao)classPathXmlApplicationContext.getBean("userDaoCreate");
        classPathXmlApplicationContext.destroy();//容器销毁？？？
        System.out.println("结束");
    }
}
