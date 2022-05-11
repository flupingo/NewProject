package com.SpringAOP.Client;

import com.SpringAOP.ServiceImpl.TestService;
import com.SpringAOP.Utils.TestAOPUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created：Jeffrey
 * date   ：2021/6/5 21:47
 */
public class TestAOP001 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestService.class,TestAOPUtils.class);


    }


}
