package com.springIOC.demonAnn.Service;

import com.springIOC.demonAnn.Dao.AnnUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 17:28
 */
/*
      1. 基于注解生成bean
       Component（三层以外使用）
       Controller
       Service
       Repository
     2.作用范围scope：value=指定singleTon/protoTpye
     3.生命周期
       preDestroy:销毁
       postConstruct:初始化
*/

@Service(value = "annUserServiceImpl")
@Scope()
public class AnnUserServiceImpl {
    /*
        4.注入数据：作用和xml里property标签一样
                autowired: 自动按照类型注入，没有value来指定id。如果有2个类型相同，就再匹配对象的名称和bean名称
                qualified: 和autowired一起用，value指定id
                resource:  value可以指定id
                以上3个都只能注入其他bean类型，基本类型和String不行

                Value:作用于基本类型和String，value指定数据的值

    */
    @Autowired
//    @Qualifier(value = "annUserDaoImpl1")
//    @Value(value = "")
    private AnnUserDao annUserDaoImpl1;


    @Value(value = "zhangsan")  //属性初始化
    private String name;


    public void add() {
        System.out.println("add()");
        annUserDaoImpl1.add();
    }

    void transfer(String sourceName, String targetName, Float money) {

    }

    @PostConstruct
    void init() {
//        System.out.println("初始化");
    }

    @PreDestroy
    void destroy() {
        System.out.println("销毁");
    }
}
