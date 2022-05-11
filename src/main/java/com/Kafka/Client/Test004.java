package com.Kafka.Client;

import com.Utils.ReadPropertyUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2021/8/17 20:08
 */
public class Test004 {
    public static void main(String[] args) {
        KafkaProducer kafkaProducer = new KafkaProducer(ReadPropertyUtil.loadProperty("property/kafkaProducer.properties"));
        kafkaProducer.send(new ProducerRecord("12", 1, 1, 1), new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {

            }
        });


        KafkaConsumer kafkaConsumer = new KafkaConsumer(ReadPropertyUtil.loadProperty("property/kafkaConsumer.properties"));

        List list = new ArrayList<>();
        list.add("topic");
        kafkaConsumer.subscribe(list);
        ConsumerRecords<String, Object> consumerRecords = kafkaConsumer.poll(100);
        for (ConsumerRecord<String, Object> consumerRecord : consumerRecords) {

        }


    }
}
