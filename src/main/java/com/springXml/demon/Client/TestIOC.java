package com.springXml.demon.Client;

import com.springXml.demon.DAO.UserDao;
import com.springXml.demon.DAOImpl.UserDaoImpl;
import com.springXml.demon.Service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created：Jeffrey
 * date   ：2020/7/1 13:42
 */
public class TestIOC {
    public static void main(String[] args) {
        //1.核心容器:ApplicationContext创建对象时采取立即加载方式(懒加载)，一读取配置文件，立马创建对象.=====>适合单例？？？
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/bean.xml");

        //1.1核心容器BeanFactory:采取饿汉式方式-获取bean对象时才创建=====>适合多例
//        Resource resource=new ClassPathResource("spring/beans.xml");
//        BeanFactory beanFactory=new XmlBeanFactory(resource);

        //1.2根据文件位置，没第一个好用
        // ApplicationContext applicationContext=new FileSystemXmlApplicationContext("C:\\Users\\dell\\Desktop");

        //2.根据唯一标志获取bean对象
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userDaoService");
        UserDao userDao = applicationContext.getBean("userDao", UserDaoImpl.class);//传一个字节码UserDaoImpl
        System.out.println(userService);




    }
}
