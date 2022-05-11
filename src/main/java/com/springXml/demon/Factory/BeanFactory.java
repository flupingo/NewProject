package com.springXml.demon.Factory;

import Fundation.Animal;
import Fundation.FactoryTest.Car;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 1.读取配置文件；2.反射获取对象
 * Created：Jeffrey
 * date   ：2020/7/1 9:42
 */
public class BeanFactory {
    private static Properties properties;
    private static Map<String, Object> beanMap = new HashMap<String, Object>();

    //1.获取依赖bean的配置
    static {
        try {
            properties = new Properties();
            //读取配置文件
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("property/bean.properties");
            properties.load(in);
            Enumeration enumeration = properties.keys();
            while (enumeration.hasMoreElements()) {
                String key = enumeration.nextElement().toString();
                Object obj = Class.forName(properties.getProperty(key)).newInstance();
                beanMap.put(key, obj);
            }
//            properties.getProperty("");
        } catch (Exception e) {
//            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化property错误！");
        }
    }

    //2.根据beanName获取bean
    public static Object getBean(String beanName) {
        return beanMap.get(beanName);
    }

    //测试
    public static void main(String[] args) {


    }

 }
