package com.example.demo.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class StrInterceptor implements org.springframework.kafka.listener.RecordInterceptor<String, String> {

    @Override
    public ConsumerRecord<String, String> intercept(ConsumerRecord<String, String> record,
            Consumer<String, String> consumer) {
                if (record.value().contains("mensagem")) {
                    log.info("A mensagem contém 'mensagem': {}", record.value());
                    return record; // Retorna o registro se a condição for verdadeira
                }
                log.info("A mensagem não contém 'mensagem': {}", record.value());
                return null; // Retorna null se a condição não for satisfeita, descartando a mensagem
            }
}

