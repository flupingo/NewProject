package com.springIOC.demonAnn.Client;

import com.springIOC.demonAnn.Config.SpringConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * Created：Jeffrey
 * date   ：2020/7/2 13:21
 */
public class TestConfigrationAnn {
    public static void main(String[] args) {
        //1.构造bean容器
        AnnotationConfigApplicationContext as=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        QueryRunner an=(QueryRunner)as.getBean("queryRunner");
//        QueryRunner an1=(QueryRunner)as.getBean("queryRunner");
//        System.out.println(an==an1);

        DataSource dataSource=(DataSource)as.getBean("dataSource");
        System.out.println(dataSource);




    }
}
