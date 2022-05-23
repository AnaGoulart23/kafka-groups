package com.br.producerpayments.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Component
public class PaymentProducer {
    @Value("${payment.topic}")
    private String paymentTopic;

    private final KafkaTemplate kafkaTemplate;

    public PaymentProducer(final KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(final @RequestBody String order) {
        final String mensageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(paymentTopic, mensageKey, order);
    }
}
