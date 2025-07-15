package com.ms.kafka.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class DltConsumer {

    @KafkaListener(topics = "payment-events.DLT", groupId = "dlt-consumer-group")
    public void listen(byte[] message,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                       @Header(KafkaHeaders.OFFSET) long offset,
                       @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                       @Header(name = "kafka_exception_message", required = false) String errorMessage) {

        System.out.println("🚨 DLT Message Received");
        System.out.println("➡ Topic: " + topic);
        System.out.println("➡ Partition: " + partition + ", Offset: " + offset);
        System.out.println("➡ Error: " + errorMessage);
        System.out.println("➡ Payload: " + new String(message));
    }
}
