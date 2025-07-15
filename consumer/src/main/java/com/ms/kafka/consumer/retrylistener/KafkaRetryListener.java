package com.ms.kafka.consumer.retrylistener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.RetryListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("retryLogger")
public class KafkaRetryListener implements RetryListener {
    @Override
    public void failedDelivery(ConsumerRecord<?, ?> record, Exception ex, int deliveryAttempt) {
        log.warn("⚠️ Retry attempt {} failed for record: {}", deliveryAttempt, record.value(), ex);
    }
}
