package com.Kafka.Client;

import Fundation.User;
import com.Utils.ReadPropertyUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * Created：Jeffrey
 * date   ：2021/5/31 17:40
 */
public class TestKafkaProducer {
    public static void main(String[] args) {

        User user = new User();
        user.setName("zhang");
        user.setAge(32);
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject01 = new JSONObject();
        jsonObject01.put("yang", "jie");

        //对象不能直接转JSON,要先转成String！！！
        jsonObject.put("json01", JSONObject.parse(JSONObject.toJSONString(user)));
        jsonObject.put("json02", jsonObject01);
        System.out.println(jsonObject);


        KafkaProducer kafkaProducer = new KafkaProducer(ReadPropertyUtil.loadProperty("property/kafkaProducer.properties"));


        //topic和数据
        ProducerRecord<String, JSONObject> record = new ProducerRecord("topic01", jsonObject);
        System.out.println("====生产者在发送数据====");
        kafkaProducer.send(record);
        System.out.println("====生产者发送完成====");

    }
}
