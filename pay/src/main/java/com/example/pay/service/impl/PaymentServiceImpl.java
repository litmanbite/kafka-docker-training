package com.example.pay.service.impl;

import org.springframework.stereotype.Service;

import com.example.pay.model.Payment;
import com.example.pay.service.PaymentService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{

    @Override
    public void sendPayment(Payment p) {
        log.info("SERVICE ::: Recebi o pagamento",p);
    }

}
