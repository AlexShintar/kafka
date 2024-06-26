package ru.shintar.metrics_consumer.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;
import ru.shintar.metrics_consumer.model.SomeMetricData;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public NewTopic topic() {
        return new NewTopic("metrics-topic", 1, (short) 1);
    }


    @Bean
    public CommonErrorHandler errorHandler(KafkaOperations<String, SomeMetricData> kafkaOperations) {
        return new DefaultErrorHandler(new DeadLetterPublishingRecoverer(kafkaOperations), new FixedBackOff(1000L, 2));
    }

}
