package com.ms.kafka.producer.controller;

import com.ms.kafka.producer.event.PaymentEvent;
import com.ms.kafka.producer.service.PaymentProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentProducer producer;

    @PostMapping
    public String produce(@RequestBody PaymentEvent event) {
        log.info("Request received for event{}", event);
        producer.send(event);
        return "Payment event sent to Kafka!";
    }
    @PostMapping("/row")
    public String produceRow(@RequestBody String event) {
        log.info("Request received for event{}", event);
        producer.sendRaw(event);
        return "Payment event sent to Kafka!";
    }
}
