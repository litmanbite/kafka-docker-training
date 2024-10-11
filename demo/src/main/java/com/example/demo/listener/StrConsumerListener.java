package com.example.demo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class StrConsumerListener {

    @KafkaListener(groupId = "group-1", topicPartitions = {
        @TopicPartition(topic = "str-topic", partitions = "0") // Corrigido aqui
    }, containerFactory = "validMsgContainerFactory")
    public void listener(String msg) {
        log.info("Received message in listener: {}", msg);
    }

    @KafkaListener(groupId = "group-1", topicPartitions = {
        @TopicPartition(topic = "str-topic", partitions = "1") // Corrigido aqui
    }, containerFactory = "validMsgContainerFactory")
    public void log(String msg) {
        log.info("Received message in log: {}", msg);
    }
}
