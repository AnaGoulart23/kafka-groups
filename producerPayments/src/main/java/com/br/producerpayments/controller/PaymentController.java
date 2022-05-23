package com.br.producerpayments.controller;

import com.br.producerpayments.producer.PaymentProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payments")
@Slf4j
public class PaymentController {
        private final PaymentProducer paymentProducer;

        public PaymentController(PaymentProducer paymentProducer) {
            this.paymentProducer = paymentProducer;
        }

        @PostMapping
        public void send(@RequestBody String payment) {
            paymentProducer.send(payment);
        }
}
