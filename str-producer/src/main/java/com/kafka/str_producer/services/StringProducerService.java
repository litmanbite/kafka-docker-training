package com.kafka.str_producer.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class StringProducerService {

    private final KafkaTemplate<String, String> template;

    public void sendMsg(String msg) {
        // Envia a mensagem e obtém um CompletableFuture
        CompletableFuture<SendResult<String, String>> future = template.send("str-topic", msg);

        future.thenAccept(result -> {
            // Log de sucesso
            log.info("Sent message [{}] with offset [{}]", msg, result.getRecordMetadata().offset());//offset é a linha no kafdrop
        }).exceptionally(err -> {
            // Log de erro
            log.error("Unable to send message [{}] due to: {}", msg, err.getMessage(), err);
            return null; // Retorna null para encadear
        });
    }
}






