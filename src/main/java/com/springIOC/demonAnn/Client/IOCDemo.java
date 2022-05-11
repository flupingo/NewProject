package com.springIOC.demonAnn.Client;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.List;
import java.util.Map;

/**
 * Created：Jeffrey
 * date   ：2021/6/12 13:29
 */
public class IOCDemo {
    private BeanFactory beanFactory;
    private List<BeanFactoryPostProcessor>list;



    void BeanFactoryPostProcessor(BeanFactory beanFactory) {

    }

    void BeanPostProcessor() {

    }


    class BeanFactory {
        private Map<String, RootBeanDefinition> beanDefinitionMap; //key-对象名
        private List<String> beanNameList;
        private List<BeanPostProcessor>list;

    }

    class RootBeanDefinition {
        private String className;
        private boolean ifSingleTon;
        private String beanName;

    }

}
