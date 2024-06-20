package ru.shintar.metrics_producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.shintar.metrics_producer.model.SomeMetricData;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class MetricsProducerService {

    private final KafkaTemplate<String, SomeMetricData> template;
    private final MetricGenerator generator;


    @Scheduled(fixedRate = 20L, initialDelay = 10L, timeUnit = TimeUnit.SECONDS)
    public void schedule() {
        sendRandom();
    }

    public void sendRandom(){
        send(generator.getSomeRandomMetric());
    }

    public void send(SomeMetricData message) {
        log.info("Sending message: {}", message);
        template.send("metrics-topic", message);
        log.info("Message sent");
    }
}
