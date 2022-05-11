package com.springXml.demon.Client;

import com.springXml.demon.Factory.BeanFactory;
import com.springXml.demon.Service.UserServiceImpl;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 10:02
 */
public class TestFactory {
    public static void main(String[] args) {
        UserServiceImpl userService= (UserServiceImpl) BeanFactory.getBean("userService");
        userService.add();




    }
}
