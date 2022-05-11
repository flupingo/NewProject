package com.SpringBoot.Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created：Jeffrey
 * date   ：2020/8/2 23:07
 */
//标注主程序，是Spring boot应用
@SpringBootApplication
public class HelloWorld {
    public static void main(String[] args) {
        //启动应用
        SpringApplication.run(HelloWorld.class, args);

    }


}
