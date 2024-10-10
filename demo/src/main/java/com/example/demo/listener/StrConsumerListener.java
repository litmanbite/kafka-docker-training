package com.example.demo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class StrConsumerListener {

    @KafkaListener(groupId = "group-1",topics = "str-topic",containerFactory = "strContainerFactory" )
    public void listener(String msg){
        log.info("Recive message {}",msg);
    }
}
