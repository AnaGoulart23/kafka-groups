package com.br.consumerone.consumer;

import com.br.consumerone.dto.Payment;
import com.br.consumerone.entity.ClientEntity;
import com.br.consumerone.repository.ClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ClientConsumer {
    private final ClientRepository clientRepository;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public ClientConsumer(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @KafkaListener(topics = "${payment.topic}", groupId = "${spring.kafka.consumer.group-id}")
        public void consumerOrder(String message) {
        try {
            Payment payment = mapper.readValue(message, Payment.class);
            System.out.println("CONSUMER_1 " + payment.getOrder().getOrderNumber());
            clientRepository.save(new ClientEntity(payment.getClient().getName(), payment.getClient().getEmail()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
