package com.ms.kafka.producer.service;

import com.ms.kafka.producer.event.PaymentEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentProducer {

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;
    private final KafkaTemplate<String, String> rawMessgae;

    public void send(PaymentEvent event) {
        log.info("Sending event : {}", event);
        CompletableFuture<SendResult<String, PaymentEvent>> future =
                kafkaTemplate.send("payment-events", event);

        future.thenAccept(result -> {
            log.info("✅ Event sent to partition {}, offset {}",
                    result.getRecordMetadata().partition(),
                    result.getRecordMetadata().offset());
        }).exceptionally(ex -> {
            log.error("❌ Failed to send event", ex);
            return null;
        });

    }
    public void sendRaw(String event) {
        log.info("Sending raw event : {}", event);
        CompletableFuture<SendResult<String, String>> future =
                rawMessgae.send("payment-events", event);

        future.thenAccept(result -> {
            log.info("✅ Raw Event sent to partition {}, offset {}",
                    result.getRecordMetadata().partition(),
                    result.getRecordMetadata().offset());
        }).exceptionally(ex -> {
            log.error("❌ Failed to send raw event", ex);
            return null;
        });

    }
}
