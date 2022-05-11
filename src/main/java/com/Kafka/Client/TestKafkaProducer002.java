package com.Kafka.Client;

import com.Utils.ReadPropertyUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import scala.Int;

import java.util.*;


/**
 * Created：Jeffrey
 * date   ：2021/7/3 9:55
 */
public class TestKafkaProducer002 {
    public static void main(String[] args) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "xiaoxiao");
            jsonObject.put("age", "12");
            String js = jsonObject.toJSONString();
            KafkaProducer kafkaProducer = new KafkaProducer(ReadPropertyUtil.loadProperty("property/kafkaProducer.properties"));
            ProducerRecord<String, String> record = new ProducerRecord("topic", "name", js);
            kafkaProducer.send(record);


            KafkaConsumer kafkaConsumer = new KafkaConsumer(ReadPropertyUtil.loadProperty(""));
            kafkaConsumer.subscribe(Arrays.<String>asList("topic"));
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(100);//拉取数据
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                consumerRecord.key();
                consumerRecord.value();
                consumerRecord.topic();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
