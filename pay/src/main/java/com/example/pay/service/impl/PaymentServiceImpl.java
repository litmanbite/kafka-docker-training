package com.example.pay.service.impl;

import java.io.Serializable;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.pay.model.Payment;
import com.example.pay.service.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final KafkaTemplate<String,Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment p) {
        log.info("SERVICE ::: Recebi o pagamento {}",p);
        Thread.sleep(1000);

        log.info("Enviando...");
        kafkaTemplate.send("payment",p);
    }

}
