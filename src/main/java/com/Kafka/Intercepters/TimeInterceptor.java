package com.Kafka.Intercepters;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import java.util.Map;

/**
 * kafka生产者拦截器
 * Created：Jeffrey
 * date   ：2020/8/7 19:51
 */
public class TimeInterceptor implements ProducerInterceptor {
    @Override
    public ProducerRecord  onSend(ProducerRecord producerRecord) {
        return null;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
