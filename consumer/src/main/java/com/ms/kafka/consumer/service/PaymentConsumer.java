package com.ms.kafka.consumer.service;

import com.ms.kafka.consumer.event.PaymentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentConsumer {

    @KafkaListener(topics = "payment-events", groupId = "payment-group")
    public void consume(PaymentEvent event, Acknowledgment ack) {
        log.info("🔄 Consumed event: {}", event);

        try {
            // simulate processing
            Thread.sleep(500); // Optional: mock delay
            log.info("✅ Processed event: {}", event);

            ack.acknowledge(); // Commit only after success

        } catch (Exception e) {
            log.error("❌ Processing failed", e);
            // No ack here, will retry
        }
    }

}
