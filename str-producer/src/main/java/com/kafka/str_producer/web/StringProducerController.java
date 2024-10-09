package com.kafka.str_producer.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.str_producer.services.StringProducerService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/producer")
public class StringProducerController {

    private final StringProducerService service;

    @PostMapping
    public ResponseEntity sendMsg(@RequestBody String msg){
        service.sendMsg(msg);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
