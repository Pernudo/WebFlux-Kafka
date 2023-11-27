package com.pernudo.app_producer.components;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    private KafkaProducer<String, String> producer;

    public Producer(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<String, String>(properties);
    }

    public void send(String topic, String message) {
        producer.send(new ProducerRecord<String, String>(topic, message));
    }

    public void close(){
        producer.close();
    }
}
