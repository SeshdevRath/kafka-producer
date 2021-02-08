package com.kafkaproducer.example.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class SynchronousProducer {

    public void produce(String topic, String key, String value) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092, localhost:9093, localhost:9094");
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);

        Producer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

        try {
            RecordMetadata metadata = producer.send(record).get();
            System.out.println("Message is sent to partition no " + metadata.partition() + " and offset " + metadata.offset());
            System.out.print("SynchronousProducer completed with success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("SynchronousProducer failed with exception");
        } finally {
            producer.close();
        }
    }
}
