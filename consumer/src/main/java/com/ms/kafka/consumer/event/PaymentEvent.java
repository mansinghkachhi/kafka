package com.ms.kafka.consumer.event;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEvent {
    private String paymentId;
    private String userId;
    private double amount;
    private String status;
}
