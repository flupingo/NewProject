package com.springIOC.demonAnn.Config;

import Fundation.Dog;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import com.springIOC.demonAnn.Entity.AnnUser;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
  1.Configuration:指定类是个配置类
  2.ComponentScan:和xml里componentScan一样
  3.Bean：将方法的返回值作为bean对象，存入spring的IOC容器中，默认key是方法名称
          name-->指定bean名称
          scope-->指定singleton或者prototype
          qualified->指定参数的bean名称（类似autowired+qualified，多例情况下使用）
    细节：当使用注解配置方法时，如果方法有参数，spring会从容器中查找有没有可用的bean对象，查找方式和autowired相同
  4.import：主配置类使用，引入其他的配置类，其他配置类无需@Configuration，形成主次配置关系

        */
@ComponentScan(value = {"com.springIOC", "com.Mybatis"})
@Configuration
@Import(JdbcConfigration.class)
@PropertySource("classpath:property/jdbc.properties")
public class SpringConfiguration {
    @Autowired
    AnnUser annUser;
    @Value("${jdbc.driver}")
    private  String driver;
    @Value("${jdbc.url}")
    private  String url;
    @Value("${jdbc.user}")
    private  String user;
    @Value("${jdbc.password}")
    private  String password;

    @Bean(name = "queryRunner")
    @Scope("singleton")
    public QueryRunner getQueryRunner(@Qualifier("dataSource") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Primary
    @Bean(name="dataSource")
    public DataSource creatDataSource() {
        ComboPooledDataSource co = new ComboPooledDataSource();
        try {
            co.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        co.setJdbcUrl(url);
        co.setUser(user);
        co.setPassword(password);
        return co;
    }


}
