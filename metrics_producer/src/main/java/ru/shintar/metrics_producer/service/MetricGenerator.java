package ru.shintar.metrics_producer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Service;
import ru.shintar.metrics_producer.model.SomeMetricData;

import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MetricGenerator {
    private final MetricsEndpoint metricsEndpoint;

    public SomeMetricData getSomeRandomMetric() {

        Set<String> metricNames = metricsEndpoint.listNames().getNames();

        String metricName = metricNames.stream()
                .skip(new Random().nextInt(metricNames.size())).findFirst().orElse(null);

        return metricBuilder(metricName);
    }

    private SomeMetricData metricBuilder(String metricName) {

        var metric = metricsEndpoint.metric(metricName, null);

        double value = metric
                .getMeasurements()
                .get(0)
                .getValue();

        return SomeMetricData
                .builder()
                .value(value)
                .description(Optional.ofNullable(metric.getDescription()).orElse(""))
                .name(metricName)
                .build();
    }
}