package com.Kafka.Client;

import com.Utils.ReadPropertyUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.Semaphore;

/**
 * 生产者对象
 * Created：Jeffrey
 * date   ：2020/8/6 15:18
 */
public class MyProducer {

    public static void main(String[] args) {
        try {
            //生产者是自定义的，可以根据需要进行装配？？？？
            KafkaProducer kafkaProducer = new KafkaProducer(ReadPropertyUtil.loadProperty("property/kafkaProducer.properties"));

            //生产者发送数据,producerRecord-发送数据对象！！！
            //1.不带回调函数(不指定分区)
//            for (int i = 0; i < 10; i++) {
//                kafkaProducer.send(new ProducerRecord("topic", "data" + i));
//            }
            //2.带回调函数(不指定分区，有分区器给你分配) 方法会执行回调方法onCompletion()
            for (int i = 0; i < 10; i++) {
                //=====ProducerRecord（String topic, V value）---你可以发送任意数据！！！=====
                kafkaProducer.send(new ProducerRecord("topic", "data" + i), (recordMetadata, e) -> {
                    if (null != e) {
                        // 回调函数 ===> callback返回对象包含存储到服务器的数据：分配到哪个分区了？序号是几？
                        System.out.println("====分区===" + recordMetadata.partition());
                        System.out.println("===offset===" + recordMetadata.offset()); //返回的是+1 offset
                        recordMetadata.topic();

                    } else {
                        e.printStackTrace();
                    }
                });
            }

//            KafkaProducer kafkaProducer1=new KafkaProducer(null);
//
//            JSONObject jsonObject= JSON.parseObject(null);
//            kafkaProducer1.send(new ProducerRecord("",null));


            //3.指定分区
            for (int i = 0; i < 100; i++) {
                //1.key和partition都是为了指定分区，同时存在以partition为主，key不起作用；
                // 2.只有key，根据hash（key）分配分区；
                // 3.都未指定，则round-robin！！！
                kafkaProducer.send(new ProducerRecord("topic01", 0, "key", String.valueOf(i)));
                System.out.println("===生产信息=== partition=topic01, key=key, value=" + i);
            }

            //关闭资源
            kafkaProducer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Properties loadProperty() {
        Properties properties = new Properties();
        //部分配置信息在ProducerConfig
        InputStream in = MyProducer.class.getClassLoader().getResourceAsStream("property/kafkaProducer.properties");
        try {
            properties.load(in);
//            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return properties;
        }
    }


}
