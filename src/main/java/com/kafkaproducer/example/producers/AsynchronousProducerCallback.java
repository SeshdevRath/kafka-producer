package com.kafkaproducer.example.producers;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class AsynchronousProducerCallback implements Callback {
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (e != null) {
            System.out.print("AsynchronousProducer failed with an exception");
        } else {
            System.out.print("AsynchronousProducer completed with success");
        }
    }
}
