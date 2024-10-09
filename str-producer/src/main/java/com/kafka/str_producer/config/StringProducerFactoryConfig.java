    package com.kafka.str_producer.config;

    import java.util.HashMap;

    import org.apache.kafka.clients.producer.ProducerConfig;
    import org.apache.kafka.common.serialization.StringSerializer;
    import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.kafka.core.DefaultKafkaProducerFactory;
    import org.springframework.kafka.core.KafkaTemplate;
    import org.springframework.kafka.core.ProducerFactory;

    import lombok.RequiredArgsConstructor;

    @Configuration
    @RequiredArgsConstructor
    public class StringProducerFactoryConfig {

        private final KafkaProperties properties;

        @Bean
        public ProducerFactory<String,String> producerFactory(){
            HashMap<String, Object> config = new HashMap<>();
            config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
            config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            return new DefaultKafkaProducerFactory<>(config);
        }

        @Bean
        public KafkaTemplate<String,String> kafkaTemplate( ProducerFactory<String,String> producerFactory){
            return new KafkaTemplate<>(producerFactory);
        }
    }
