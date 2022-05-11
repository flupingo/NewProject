package com.SpringAOP.Client;

import com.SpringAOP.Service.AccountService;
import com.SpringAOP.ServiceImpl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created：Jeffrey
 * date   ：2020/7/3 9:49
 */
public class TestAOP {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext sd = new ClassPathXmlApplicationContext("spring/bean.xml");





        //这里bean对象是基于接口实现的动态代理对象！！！AccountService虽然有@Component，但是生成了代理对象
        AccountService accountService = (AccountService) sd.getBean("accountServiceImpl");
        accountService.saveAccount();
//        accountService.deleteAccount();

    }
}
