package com.br.producerpayments.consumer;

import com.br.producerpayments.dto.Payment;
import com.br.producerpayments.entity.OrderEntity;
import com.br.producerpayments.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class orderConsumer {
    private final OrderRepository orderRepository;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public orderConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "${payment.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumerClient(String message) {
        try {
            Payment payment = mapper.readValue(message, Payment.class);
            System.out.println("CONSUMER_2 " + payment.getOrder().getOrderNumber());
            orderRepository.save(new OrderEntity(
                    payment.getOrder().getOrderNumber(),
                    payment.getOrder().getStoreName()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
