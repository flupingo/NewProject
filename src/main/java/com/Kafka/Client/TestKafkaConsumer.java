package com.Kafka.Client;

import com.Utils.ReadPropertyUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;

/**
 * Created：Jeffrey
 * date   ：2021/5/31 21:15
 */
public class TestKafkaConsumer {
    public static void main(String[] args) {
        KafkaConsumer kafkaConsumer = new KafkaConsumer(ReadPropertyUtil.loadProperty("property/kafkaConsumer.properties"));
        //订阅主题
        kafkaConsumer.subscribe(Arrays.asList("topic01"));
        ConsumerRecords<String, Object> consumerRecords = kafkaConsumer.poll(1000);
        System.out.println("====消费者在接收数据====");
        for (ConsumerRecord<String, Object> consumerRecord : consumerRecords) {
            System.out.println("offset:" + consumerRecord.offset() + "value:" + consumerRecord.value() + "partition:"
                    + consumerRecord.partition());
        }



        System.out.println("====消费者接收完成====");
    }
}
