package com.example.pay.resource.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pay.model.Payment;
import com.example.pay.resource.PaymentResource;
import com.example.pay.service.PaymentService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pay")
public class PaymentResourceImpl implements PaymentResource{

    private final PaymentService service;// a interface

    @Override
    public ResponseEntity<Payment> sendPayment(Payment p) {
        service.sendPayment(p); // Envia o pagamento
        return ResponseEntity.status(201).body(p); // Retorna o pagamento no corpo da resposta
    }
}
