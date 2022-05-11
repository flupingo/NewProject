package com.springIOC.demonAnn.Client;

import com.springIOC.demonAnn.Entity.AnnUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Constructor;

/**
 * Created：Jeffrey
 * date   ：2021/6/15 21:25
 */
public class TestDependentInjection {
    @Autowired
    AnnUser annUser;  //依赖 AnnUser对象

    private String name;

    void get() {
        annUser.equals("enjoy");
    }

    public static void main(String[] args) {
        try {
            Constructor constructor = AnnUser.class.getDeclaredConstructor();
            AnnUser annUser = (AnnUser) constructor.newInstance();

            Constructor constructor1=AnnUser.class.getDeclaredConstructor(String.class);
//            constructor1.newInstance();

            //有参构造器就得传参！！！
            AnnUser annUser1= (AnnUser) constructor1.newInstance("zhangsan");

            System.out.println(annUser1.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
