package com.example.demo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.demo.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class StrConsumerListener {

    @StrConsumerCustomListener(topics = "str-topic", groupId = "group-1")
    public void listener(String msg) {
        log.info("Received message in listener: {}", msg);
    }

    @StrConsumerCustomListener(topics = "str-topic", groupId = "group-1")
    public void log(String msg) {
        log.info("Received message in log: {}", msg);
    }
}
