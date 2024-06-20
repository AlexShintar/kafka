package ru.shintar.metrics_consumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.shintar.metrics_consumer.model.SomeMetricData;
import ru.shintar.metrics_consumer.model.MetricDataDTO;


@Service
@Slf4j
@RequiredArgsConstructor
public class MetricsListener {

    private final  MetricService service;

    @KafkaListener(topics = "metrics-topic", id = "metrics-group")
    public void listener(SomeMetricData someMetricData) {
        log.info("Received metric: {}", someMetricData.getName());
        service.saveMetric(new MetricDataDTO(someMetricData));
    }
}
