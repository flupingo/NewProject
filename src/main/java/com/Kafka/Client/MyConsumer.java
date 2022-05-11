package com.Kafka.Client;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContext;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 消费者对象
 * Created：Jeffrey
 * date   ：2020/8/7 16:19
 */
public class MyConsumer {
    public static void main(String[] args) {
        //迭代器
        ArrayList list = new ArrayList();
        list.iterator();

        //1.加载配置
        Properties properties = new Properties();
        InputStream inputStream = MyConsumer.class.getClassLoader().getResourceAsStream("property/kafkaConsumer.properties");
        // Thread.currentThread().getContextClassLoader().getResourceAsStream("");
        try {
            properties.load(inputStream);
            //消费者组--配置文件

            //服务器

            //======反序列化器---读取存储文件为数据！！！！！！====
            KafkaConsumer kafkaConsumer = new KafkaConsumer(properties); //消费者1


            KafkaConsumer kafkaConsumer2 = new KafkaConsumer(properties);  //消费者2

            //2.订阅主题---可以消费哪些主题的数据
            kafkaConsumer.subscribe(Arrays.asList("topic01", "topic"));

            //3.====拉取数据，拉取等待100ms，没有就停止pull？？？====

            //3.1Map<TopicPartition, List<ConsumerRecord<K, V>>> records,一个partition对应一排数据？

            //3.2必须指定类型<String key, String value>
            ConsumerRecords<String, String> consumerRecords;

            while (true) {
                consumerRecords = kafkaConsumer.poll(100);  //拉取的数据

                for (ConsumerRecord consumerRecord : consumerRecords) {
                    System.out.println("===消费信息===   kye:" + consumerRecord.key() + ", value:" + consumerRecord.value() + ", offset:" +
                            consumerRecord.offset() + "！！！");    //offset -- 获取拉取的数据坐标！！！
                }
            }

            //3.3


            // kafkaConsumer.seekToEnd();

            //4.关闭
//            kafkaConsumer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    static void testAsyncConsumer() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                try {
                    KafkaConsumer kafkaConsumer = new KafkaConsumer(null);
                    kafkaConsumer.poll(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }


    }
}
