package com.example.pay.resource;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.pay.model.Payment;

public interface PaymentResource {

    @PostMapping
    ResponseEntity<Payment> sendPayment(@RequestBody Payment p);
}
