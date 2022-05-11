package com.Kafka.Client;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Created：Jeffrey
 * date   ：2021/8/14 10:32
 */
public class Test001 {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(Test001.class.getResourceAsStream(""));
            KafkaProducer kafkaProducer = new KafkaProducer(properties);

            ProducerRecord record = new ProducerRecord("topic", "21");
            Future future = kafkaProducer.send(record); //1.过滤消息；2.序列化；3.发送
            future.get();

            kafkaProducer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {

                }
            });



            Map<String, ?> map = new HashMap<>();
//            map.put("1",2);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
