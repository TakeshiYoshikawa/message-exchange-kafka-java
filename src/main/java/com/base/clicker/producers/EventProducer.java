package com.base.clicker.producers;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class EventProducer {
    private final String topic;
    private final KafkaProducer<String, String> producer;

    public EventProducer(String bootstrapServers, String topic) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        this.producer = new KafkaProducer<>(properties);
        this.topic = topic;
    }

    public void sendEvent(String userId, String eventDetails){
        String message = String.format("[User]: %s || [Event]: %s", userId, eventDetails);
        
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, userId, message);

        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception){
                if (exception != null)
                    exception.printStackTrace();

                System.out.printf("Sent message with key %s to partition %d with offset %d%n",
                    userId, metadata.partition(), metadata.offset());
            }
        });
    }

    public void close(){
        producer.close();
    }
}
